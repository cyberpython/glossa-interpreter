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
import java.nio.charset.Charset;
import java.util.List;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 *
 * @author cyberpython
 */
public class Main {

    private static final String APP_NAME = "Glossa-Interpreter - Διερμηνευτής για τη ΓΛΩΣΣΑ";
    private static final String VERSION = "Έκδοση: 1.0.4";
    private static final String SOURCE_FILE_NOT_DEFINED = "Δεν καθορίσατε το αρχείο πηγαίου κώδικα.";
    private static final String WRONG_USAGE = "Λάθος τρόπος χρήσης.";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] arguments = args;

        OptionParser parser = new OptionParser("hVif:");

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
                List<String> remainingArgs = options.nonOptionArguments();
                if (remainingArgs.size() > 0) {
                    boolean interactive = false;
                    File inputFile = null;
                    if (options.has("i")) {
                        interactive = true;
                    }
                    if (options.has("f")) {
                        inputFile = new File((String) options.valueOf("f"));
                    }
                    File sourceCodeFile = new File(remainingArgs.get(0));
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
        printFile("/glossa/resources/license.txt", out);
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

    private static void printVersionInfo(PrintStream out) {
        out.println(APP_NAME);
        out.println(VERSION);
        out.println();
    }
}
