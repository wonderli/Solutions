import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String s){
        int len = s.length();
        int result = 0;
        for(int i = 0; i < len; i++){
            result += s.charAt(i) - '0';
        }
        System.out.println(result);
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
