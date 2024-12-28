/*
 *  The MIT License
 *
 *  Copyright 2010 Georgios Migdos <cyberpython@gmail.com>.
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
package glossa;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import glossa.external.ExternalFunction;
import glossa.external.ExternalProcedure;
import glossa.external.ExternalSubprograms;
import glossa.ui.cli.CLI;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;

/**
 *
 * @author cyberpython
 */
public class Main {

    private static final String APP_NAME = "Glossa-Interpreter - Διερμηνευτής για τη ΓΛΩΣΣΑ";
    private static final String VERSION = "Έκδοση: "+readVersion();
    private static final String LICENSE_NAME = "Άδεια χρήσης MIT (MIT LICENSE)";
    private static final String SOURCE_FILE_NOT_DEFINED = "Δεν καθορίσατε το αρχείο πηγαίου κώδικα.";
    private static final String WRONG_USAGE = "Λάθος τρόπος χρήσης.";

    static class CmdLineOpts {
        @Option(names = {"-h", "--help"}, usageHelp = true, description = "εμφανίζει αυτό το μήνυμα")
        private boolean helpRequested = false;
    
        @Option(names = { "-f", "--file" }, paramLabel = "INPUTFILE", description = "τοποθεσία_αρχείου_εισόδου\n"
        + ": Η είσοδος των εντολών ΔΙΑΒΑΣΕ\n"
        + "  γίνεται από το αρχείο εισόδου,\n"
        + "  διαβάζοντας μία γραμμή ανά εντολή ΔΙΑΒΑΣΕ")
        File inputFile;
    
        @Parameters(paramLabel = "FILE", description = "τοποθεσία αρχείου πηγαίου κώδικα")
        File sourceFile;
    
        @Option(names = { "-v", "--version" }, versionHelp = true, description = "εμφανίζει την έκδοση του διερμηνευτή")
        private boolean showVersion = false;

        @Option(names = { "-i", "--interactive" }, description = "εμφανίζει την έκδοση του διερμηνευτή")
        private boolean interactive = false;
        
    }

    private static void loadExternalSubprograms() {
    
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
                                            ExternalSubprograms.getInstance().addFunction(f);
                                        } else if (foundExternalProc) {
                                            Class<? extends ExternalProcedure> externalProcClass = clazz.asSubclass(ExternalProcedure.class);
                                            Constructor<? extends ExternalProcedure> ctor = externalProcClass.getConstructor();
                                            ExternalProcedure p = ctor.newInstance();
                                            ExternalSubprograms.getInstance().addProcedure(p);
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
                            e.printStackTrace();
                        }
                    } catch (IOException ioe) {
                    }
    
                }
    
            }
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CmdLineOpts opts = new CmdLineOpts();
        
        try {
            new CommandLine(opts).parseArgs(args);
            if (opts.helpRequested || opts.showVersion) {
                if (opts.showVersion) {
                    printVersionInfo(System.out);
                    printLicense(System.out);
                }
                if (opts.helpRequested) {
                    printHelpMessage(System.out);
                }
            } else {
                if ((opts.sourceFile != null) && opts.sourceFile.isFile()) {
                    
                    loadExternalSubprograms();

                    CLI cli = new CLI(opts.interactive);
                    if (opts.inputFile != null) {
                        cli.execute(opts.sourceFile, opts.inputFile);
                    } else {
                        cli.execute(opts.sourceFile);
                    }

                } else {
                    System.out.println(SOURCE_FILE_NOT_DEFINED);
                    System.out.println();
                    printHelpMessage(System.out);
                }
            }
        } catch (ParameterException pe) {
            System.out.println(WRONG_USAGE);
            System.out.println();
            printHelpMessage(System.out);
        }
        
    }

    private static void printHelpMessage(PrintStream out) {
        printFile("/glossa/resources/usage.txt", out);
    }

    private static void printLicense(PrintStream out) {
        out.println(LICENSE_NAME);
    }

    private static void printFile(String fileURL, PrintStream out) {
        BufferedReader r = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(fileURL), Charset.forName("UTF-8")));
        String line = "";
        try {
            while ((line = r.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException ioe) {
        }
    }
    
    public static String readVersion() {
        String result="Άγνωστη";
        try {
            Properties p = new Properties();
            p.load(Main.class.getResourceAsStream("/glossa/resources/version.properties"));
        	result = p.getProperty("version");
          }
          catch (Exception e) {
          }
        return result;
    }

    private static void printVersionInfo(PrintStream out) {
        out.println(APP_NAME);
        out.println(VERSION);
    }
}
