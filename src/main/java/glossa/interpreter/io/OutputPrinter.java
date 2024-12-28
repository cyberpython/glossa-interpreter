package glossa.interpreter.io;

import java.io.PrintStream;

public class OutputPrinter implements IOutputPrinter{
  
  private PrintStream out;

  public OutputPrinter(PrintStream out){
    this.out = out;
  }

  public void print(String s){
    out.print(s);
  }

  public void println(String s){
    out.println(s);
  }

  @Override
  public void println() {
    out.println();
  }

}
