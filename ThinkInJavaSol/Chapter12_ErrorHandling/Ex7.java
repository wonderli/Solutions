//Write code to generate and catch an ArraylndexOutOfBoundsException.
import java.util.logging.*;
import java.io.*;
public class Ex7{
    public static Logger logger = Logger.getLogger("Log Exception");
    public static void main(String[] args){
        StringWriter trace = new StringWriter();
        try{
            int size = 10;
            int array[] = new int[size];
            for(int i = 0; i < (size + 1); i ++){
                array[i] = i;
            }
        }catch(Exception e) {
            System.err.println("Catch it!");
            e.printStackTrace(new PrintWriter(trace));
            logger.severe(trace.toString());
        }

    }
}
