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

import java.io.File;
import java.io.PrintStream;


/**
 *
 * @author cyberpython
 */
public class Main {

    private static final String APP_NAME = "Glossa-Interpreter - Διερμηνευτής για τη ΓΛΩΣΣΑ\nΈκδοση: 0.2";
    private static final String COPYRIGHT_NOTICE = "Copyright © 2010 Γεώργιος Μίγδος <cyberpython@gmail.com>.";
    private static final String USAGE_STRING = "Τρόπος χρήσης:\n\tjava -jar %1$s <όνομα_αρχείου_πηγαίου_κώδικα>\nπ.χ.\n\tjava -jar %1$s /home/user/Documents/Hello_World.gls";
    private static final String JAR_NAME = "glossa-interpreter.jar";
    private static final String VERSION_SWITCH = "-version";
    private static final String FILE_NOT_FOUND_ERROR = "Το αρχείο \"%1$s\" δε βρέθηκε!";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interpreter inter = new Interpreter();
        try{
            String filepath = parseArgs(args, System.out, System.err);
            if(filepath!=null){
                inter.run(args[0]);
            }
        }catch(Exception e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    private static String parseArgs(String args[], PrintStream out, PrintStream err){
        if(args.length!=1){
            err.println(String.format(USAGE_STRING, JAR_NAME));
            return null;
        }else{
            if(args[0].toLowerCase().equals(VERSION_SWITCH)){
                out.println(APP_NAME);
                out.println();
                out.println(COPYRIGHT_NOTICE);
                return null;
            }else{
                File f = new File(args[0]);
                if(f.exists()){
                    return f.getAbsolutePath();
                }else{
                    err.println(String.format(FILE_NOT_FOUND_ERROR, f.getAbsolutePath()));
                    return null;
                }
            }
        }
    }

}

