package glossa.interpreter.io;

import java.io.IOException;

public interface IInputProvider {
    
    /**
     * Returns the next line of input from the input source with any line 
     * termination characters removed. Blocks until a line of input is available.
     * 
     * A line is considered to be terminated by any one of a line feed ('\n'), 
     * a carriage return ('\r'), or a carriage return followed immediately by a 
     * linefeed.
     * 
     * @return the next line of input from the input source.
     */
    public String readLine() throws IOException;
}
