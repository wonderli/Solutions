import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) {
        int sum = 0;
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            System.out.println(sum);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
