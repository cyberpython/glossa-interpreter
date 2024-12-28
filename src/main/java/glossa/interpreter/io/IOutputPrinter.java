package glossa.interpreter.io;

public interface IOutputPrinter {

  /**
   * Prints the output to the output source.
   * @param output the output to print.
   */
  public void print(String output);

  /**
   * Prints the output to the output source and appends a newline character.
   * @param output the output to print.
   */
  public void println(String output);

  /**
   * Prints a newline character to the output source.
   */
  public void println();
}
