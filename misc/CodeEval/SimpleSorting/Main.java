import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String[] array){
        int len = array.length;
        double dArray[] = new double[len];
        for(int i = 0; i < len; i++){
            dArray[i] = Double.parseDouble(array[i]);
        }
        Arrays.sort(dArray);
        for(int i = 0; i < len; i++){
            System.out.printf("%.3f", dArray[i]);
            if(i != len - 1)System.out.print(" ");
        }
        System.out.println();
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String array[] = line.split(" ");
                solve(array);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
