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

import glossa.ui.cli.CLI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] arguments = args;

        OptionParser parser = new OptionParser("hVif:");
        OptionSpec<String> remainingArgs = parser.nonOptions().ofType( String.class );

        try {
            OptionSet options = parser.parse(arguments);
            if (options.has("h") || options.has("V")) {
                if (options.has("V")) {
                    printVersionInfo(System.out);
                    printLicense(System.out);
                }
                if (options.has("h")) {
                    printHelpMessage(System.out);
                }
            } else {
                if (options.valuesOf( remainingArgs ).size() > 0) {
                    boolean interactive = false;
                    File inputFile = null;
                    if (options.has("i")) {
                        interactive = true;
                    }
                    if (options.has("f")) {
                        inputFile = new File((String) options.valueOf("f"));
                    }
                    File sourceCodeFile = new File(options.valuesOf( remainingArgs ).get(0));
                    CLI cli = new CLI(interactive);
                    if (inputFile != null) {
                        cli.execute(sourceCodeFile, inputFile);
                    } else {
                        cli.execute(sourceCodeFile);
                    }

                } else {
                    System.out.println(SOURCE_FILE_NOT_DEFINED);
                    System.out.println();
                    printHelpMessage(System.out);
                }
            }
        } catch (OptionException uoe) {
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
        //printFile("/glossa/resources/license.txt", out);
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
        	  Class clazz = Main.class;
        	  String className = clazz.getSimpleName() + ".class";
        	  String classPath = clazz.getResource(className).toString();
        	  classPath.replace("glossa/Main.class", "META-INF/MANIFEST.MF");
        	  String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
        	  Manifest manifest = new Manifest(new URL(manifestPath).openStream());
              Attributes mainAttribs = manifest.getMainAttributes();
              String version = mainAttribs.getValue("Implementation-Version");
              if(version != null) {
                  result = version;
              }
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
