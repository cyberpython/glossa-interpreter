/*
 *  The MIT License
 *
 *  Copyright 2012 Georgios Migdos <cyberpython@gmail.com>.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package glossa.external;

import com.github.rjeschke.txtmark.Processor;
import glossa.interpreter.symboltable.symbols.RuntimeArray;
import glossa.interpreter.symboltable.symbols.RuntimeArrayItemWrapper;
import glossa.interpreter.symboltable.symbols.RuntimeVariable;
import glossa.interpreter.symboltable.symbols.ValueContainer;
import glossa.messages.Messages;
import glossa.statictypeanalysis.ExpressionResultForm;
import glossa.statictypeanalysis.scopetable.parameters.ActualParameter;
import glossa.types.Type;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author cyberpython
 */
public class ExternalSubprograms {

    //TODO: Procedures
    private HashMap<String, ExternalFunction> functionCache;
    private HashMap<String, ExternalProcedure> procedureCache;

    public static ExternalSubprograms getInstance() {
        return ExternalSubprogramsHolder.INSTANCE;
    }

    private static class ExternalSubprogramsHolder {

        private static final ExternalSubprograms INSTANCE = new ExternalSubprograms();
    }

    private ExternalSubprograms() {

        functionCache = new HashMap<>();
        procedureCache = new HashMap<>();
        loadExternalSubprograms();
    }

    private void loadExternalSubprograms() {
        //FIXME: external lib lookup directory

        //TODO: maybe instead of loading the classes
        // we should load the pair <subprogramName,className>
        // and then load the appropriate class on demand

        File lookupDir = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "ΒΙΒΛΙΟΘΗΚΗ_ΓΛΩΣΣΑΣ");
        if (lookupDir.isDirectory()) {

            File[] jarFiles = lookupDir.listFiles(
                    file -> file.getAbsolutePath().toLowerCase().endsWith(".jar")
            );

            URL[] jarURLs = new URL[jarFiles.length];

            for (int i = 0; i < jarURLs.length; i++) {
                try {
                    jarURLs[i] = jarFiles[i].toURI().toURL();
                } catch (MalformedURLException mue) {
                    //ignore jarfile
                }
            }

            ClassLoader loader = URLClassLoader.newInstance(jarURLs);

            for (File file : jarFiles) {
                try {
                    try (JarFile jf = new JarFile(file)) {
                        Enumeration<JarEntry> entries = jf.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            if (name.toLowerCase().endsWith(".class")) {
                                name = name.replaceAll("\\/", ".").substring(0, name.length() - 6);
                                try {
                                    Class clazz = loader.loadClass(name);
                                    Class[] ifaces = clazz.getInterfaces();
                                    boolean foundExternalFunc = false;
                                    boolean foundExternalProc = false;
                                    for (int i = 0; i < ifaces.length; i++) {
                                        Class iface = ifaces[i];
                                        if (iface.equals(ExternalFunction.class)) {
                                            foundExternalFunc = true;
                                            break;
                                        }
                                        if (iface.equals(ExternalProcedure.class)) {
                                            foundExternalProc = true;
                                            break;
                                        }
                                    }
                                    if (foundExternalFunc) {
                                        Class<? extends ExternalFunction> externalFuncClass = clazz.asSubclass(ExternalFunction.class);
                                        Constructor<? extends ExternalFunction> ctor = externalFuncClass.getConstructor();
                                        ExternalFunction f = ctor.newInstance();
                                        functionCache.put(toCanonicalName(f.getName()), f);
                                    } else if (foundExternalProc) {
                                        Class<? extends ExternalProcedure> externalProcClass = clazz.asSubclass(ExternalProcedure.class);
                                        Constructor<? extends ExternalProcedure> ctor = externalProcClass.getConstructor();
                                        ExternalProcedure p = ctor.newInstance();
                                        procedureCache.put(toCanonicalName(p.getName()), p);
                                    }
                                } catch (ClassNotFoundException cnfe) {
                                    //ignore
                                } catch (NoSuchMethodException nsme) {
                                    //ignore
                                } catch (InstantiationException ie) {
                                    //ignore
                                } catch (IllegalAccessException iae) {
                                    //ignore
                                } catch (InvocationTargetException ite) {
                                    //ignore
                                }
                            }
                        }
                    } catch (SecurityException | IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (IOException ioe) {
                }

            }

        }
    }

    public Type checkExternalFunctionCall(String functionName, List<ActualParameter> actualParameters) throws ExternalFunctionNotFoundException,
            WrongParametersNumberForExternalSubprogramException,
            WrongParameterTypesForExternalSubprogramException {
        String searchKey = toCanonicalName(functionName);
        ExternalFunction f = functionCache.get(searchKey);

        if (f == null) {
            throw new ExternalFunctionNotFoundException(functionName);
        } else {
            List<Parameter> params = f.getParametersList();
            if (params.size() == actualParameters.size()) {
                List<ParameterTypeMismatchInstance> mismatchedParamTypes = checkParameters(f, actualParameters);
                if (mismatchedParamTypes.isEmpty()) {
                    return f.getReturnType();
                } else {
                    throw new WrongParameterTypesForExternalSubprogramException(functionName, mismatchedParamTypes);
                }
            } else {
                throw new WrongParametersNumberForExternalSubprogramException(functionName, params, actualParameters);
            }
        }
    }

    public void checkExternalProcedureCall(String procedureName, List<ActualParameter> actualParameters) throws ExternalProcedureNotFoundException,
            WrongParametersNumberForExternalSubprogramException,
            WrongParameterTypesForExternalSubprogramException {
        String searchKey = toCanonicalName(procedureName);
        ExternalProcedure proc = procedureCache.get(searchKey);

        if (proc == null) {
            throw new ExternalProcedureNotFoundException(procedureName);
        } else {
            List<Parameter> params = proc.getParametersList();
            if (params.size() == actualParameters.size()) {
                List<ParameterTypeMismatchInstance> mismatchedParamTypes = checkParameters(proc, actualParameters);
                if (!mismatchedParamTypes.isEmpty()) {
                    throw new WrongParameterTypesForExternalSubprogramException(procedureName, mismatchedParamTypes);
                }
            } else {
                throw new WrongParametersNumberForExternalSubprogramException(procedureName, params, actualParameters);
            }
        }
    }

    public Object callFunction(String functionName, List<Object> parameters, PrintStream err) throws ExternalFunctionNotFoundException {
        List<Object> parameterValues = new ArrayList<Object>();
        for (Object object : parameters) {
            if (object instanceof ValueContainer) {
                parameterValues.add(((ValueContainer) object).getValue());
            } else {
                parameterValues.add(object);
            }
        }
        String searchKey = toCanonicalName(functionName);
        ExternalFunction f = functionCache.get(searchKey);
        if (f == null) {
            throw new ExternalFunctionNotFoundException(functionName);
        } else {
            return f.execute(parameterValues, err);
        }
    }

    public void callProcedure(String procedureName, List<Object> parameters, PrintStream out, PrintStream err, InputStream in) throws ExternalProcedureNotFoundException {
        List<Object> procParameters = new ArrayList<Object>();
        for (Object object : parameters) {
            if (object instanceof ValueContainer) {
                procParameters.add(new ParameterValueWrapper(((ValueContainer) object).getValue())); //wrap the value and pass it to the procedure
            } else if (object instanceof RuntimeArray) {
                procParameters.add(object);
            } else { // Just a value - wrap it and pass it along
                procParameters.add(new ParameterValueWrapper(object));
            }
        }
        String searchKey = toCanonicalName(procedureName);
        ExternalProcedure proc = procedureCache.get(searchKey);
        if (proc == null) {
            throw new ExternalProcedureNotFoundException(procedureName);
        } else {
            proc.execute(procParameters, out, err, in);
            for (int i = 0; i < parameters.size(); i++) {
                Object object = parameters.get(i);
                if ((object instanceof RuntimeVariable) || (object instanceof RuntimeArrayItemWrapper)) {
                    ((ValueContainer) object).setValue(((ParameterValueWrapper) procParameters.get(i)).getValue());
                }
            }
        }
    }

    private List<ParameterTypeMismatchInstance> checkParameters(ExternalSubProgram sub, List<ActualParameter> actualParams) {
        List<ParameterTypeMismatchInstance> result = new ArrayList<ParameterTypeMismatchInstance>();
        List<Parameter> params = sub.getParametersList();
        Parameter param;
        ActualParameter actualParam;
        if (params.size() == actualParams.size()) {
            for (int i = 0; i < params.size(); i++) {
                param = params.get(i);
                actualParam = actualParams.get(i);
                if ((!param.getType().equals(actualParam.getType()))) { // param types differ
                    if (!(Type.REAL.equals(param.getType()) && Type.INTEGER.equals(actualParam.getType()))) {
                        result.add(new ParameterTypeMismatchInstance(i, param, actualParam));
                    } else { // integer actual param -> real formal param
                        if ((param.isArray() && (!(ExpressionResultForm.ARRAY.equals(actualParam.getForm()))))
                                || ((!param.isArray()) && (ExpressionResultForm.ARRAY.equals(actualParam.getForm())))) {
                            result.add(new ParameterTypeMismatchInstance(i, param, actualParam));
                        }
                    }
                } else {
                    if (param.isArray() && (!(ExpressionResultForm.ARRAY.equals(actualParam.getForm())))
                            || ((!param.isArray()) && (ExpressionResultForm.ARRAY.equals(actualParam.getForm())))) {
                        result.add(new ParameterTypeMismatchInstance(i, param, actualParam));
                    }
                }
            }
            return result;
        }
        throw new RuntimeException("Το πλήθος των πραγματικών παραμέτρων διαφέρει από των αναμενόμενων!");
    }

    private String toCanonicalName(String name) {
        CharSequence tmp = name.toLowerCase();
        StringBuilder sb = new StringBuilder();

        char c;
        for (int i = 0; i < tmp.length(); i++) {
            c = tmp.charAt(i);
            if (c == 'ά') {
                sb.append('α');
            } else if (c == 'έ') {
                sb.append('ε');
            } else if (c == 'ή') {
                sb.append('η');
            } else if ((c == 'ί') || (c == 'ϊ') || (c == 'ΐ')) {
                sb.append('ι');
            } else if ((c == 'ύ') || (c == 'ϋ') || (c == 'ΰ')) {
                sb.append('υ');
            } else if (c == 'ό') {
                sb.append('ο');
            } else if (c == 'ώ') {
                sb.append('ω');
            } else if (c == 'ς') {
                sb.append('σ');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public final String getHTMLDocumentation(ExternalSubProgram sp) {
        StringBuilder sb = new StringBuilder("<h1>");
        ExternalFunction f = null;
        if (sp instanceof ExternalFunction) {
            f = (ExternalFunction) sp;
            sb.append("Συνάρτηση ");
        }
        sb.append("<span class='subprogram_name'>").append(sp.getName()).append("</span></h1>\n");
        sb.append("<ul>\n");
        if (f != null) {
            sb.append("  <li> <span class='lbl retval'>Τιμή επιστροφής:</span> ").append(Messages.convertFirstLetterToUppercase(f.getReturnType().toString())).append("</li>\n");
        }
        List<Parameter> params = sp.getParametersList();
        if (params.size() > 0) {
            sb.append("  <li> <span class='lbl params'>Παράμετροι</span> ").append("\n    <ul>\n");
            for (Parameter param : params) {
                sb.append("      <li> <span class='param name'>").append(param.getName()).append("</span>: ");
                if (param.isArray()) {
                    sb.append("<span class='type array'>Πίνακας ").append(param.getType().toPluralPossesiveString()).append("</span>");
                } else {
                    sb.append("<span class='type'>").append(Messages.convertFirstLetterToUppercase(param.getType().toString())).append("</span>");
                }
                sb.append("</li>\n");
            }
        }
        sb.append("    </ul>\n");
        sb.append("  <li> <span class='lbl description'>Περιγραφή:</span> ").append(Processor.process(sp.getDescription())).append("</li>\n");
        sb.append("</ul>");
        return sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ExternalSubprograms xf = ExternalSubprograms.getInstance();
        long instantiationTime = System.currentTimeMillis();

        List params = new ArrayList();

        long beforeLoopTime = System.currentTimeMillis();
        int max = 10;
        BigDecimal[] results = new BigDecimal[max];
        BigDecimal[] randomValues = new BigDecimal[max];
        for (int i = 0; i < max; i++) {
            params.clear();
            randomValues[i] = new BigDecimal(Math.random() * 100);
            params.add(randomValues[i]);

            try {
                results[i] = (BigDecimal) xf.callFunction("κυβος", params, System.err);
            } catch (ExternalFunctionNotFoundException e1) {
                System.err.println(e1.getMessage());
            }
        }
        long afterLoopTime = System.currentTimeMillis();

        for (int i = 0; i < max; i++) {
            System.out.println(String.format("%1$6.3f^3 = %2$6.3f", randomValues[i].doubleValue(), results[i].doubleValue()));
        }

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Total time        : " + (afterLoopTime - startTime) + " msec");
        System.out.println("Instantiation time: " + (instantiationTime - startTime) + " msec");
        System.out.println("Loop time         : " + (afterLoopTime - beforeLoopTime) + " msec");
        System.out.println("Average call time : " + ((afterLoopTime - beforeLoopTime) / ((double) max)) + " msec");
        System.out.println("--------------------------------");

    }
}
