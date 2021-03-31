//Exercise 6: (1) Create two exception classes, each of which performs its own logging automatically. Demonstrate that these work.
import java.util.logging.*;
import java.io.*;
public class Ex6Exception2 extends Exception{
    public static Logger logger = Logger.getLogger("Ex6Exception1 Exception");
    public Ex6Exception2(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
