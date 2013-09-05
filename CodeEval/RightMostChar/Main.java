import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String[] input){
        String S = input[0];
        String t = input[1];
        char ta[] = t.toCharArray();
        int len = S.length();
        int pos = -1;
        for(int i = len - 1; i >= 0; i--){
            if(S.charAt(i) == ta[0]) pos = i;
        }
        System.out.println(pos);
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String input[] = line.split(",");
                solve(input);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
