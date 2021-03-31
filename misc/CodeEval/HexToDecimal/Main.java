import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String line){
        int len = line.length();
        int num = 0;
        for(int i = 0; i < len; i++){
            int curr = 0;
            if(line.charAt(i) == 'a') curr = 10;
            else if(line.charAt(i) == 'b') curr = 11;
            else if(line.charAt(i) == 'c') curr = 12;
            else if(line.charAt(i) == 'd') curr = 13;
            else if(line.charAt(i) == 'e') curr = 14;
            else if(line.charAt(i) == 'f') curr = 15;
            else curr = line.charAt(i) - '0';
            num = num * 16 + curr;
        }
        System.out.println(num);
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
