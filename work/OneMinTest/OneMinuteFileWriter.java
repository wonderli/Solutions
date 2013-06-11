import java.io.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
public class OneMinuteFileWriter implements Runnable {
    private LinkedList<String> writeQueue;
    public OneMinuteFileWriter(LinkedList<String> writeQueue){
        this.writeQueue = writeQueue;
    }
    public void run(){
        String filename = new String("output " + new Date() + ".txt");
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            for(String s : writeQueue){
                System.out.println(s);
                out.write(s);
                out.newLine();
            }
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}

