import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String line){
        int num = Integer.parseInt(line);
        int len = line.length();
        int result = 0;
        for(int i = 0; i < len; i++){
            result += (int)Math.pow((double)(line.charAt(i) - '0'), len);
        }
        if(num == result){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                solve(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
