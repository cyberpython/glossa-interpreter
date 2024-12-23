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
import java.nio.charset.Charset;
import java.util.Properties;

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
            // pe.printStackTrace();
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
