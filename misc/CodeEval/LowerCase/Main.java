import java.util.*;
import java.io.*;
public class Main {

    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line.toLowerCase());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
