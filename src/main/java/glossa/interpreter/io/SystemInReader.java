package glossa.interpreter.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInReader implements IInputProvider {
  
  private BufferedReader r;

 public SystemInReader(){
    this.r = new BufferedReader(new InputStreamReader(System.in));
  }

  @Override
  public String readLine() throws IOException {
    return r.readLine();
  }
}
