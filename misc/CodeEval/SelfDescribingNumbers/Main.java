import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String input){
        int len = input.length();
        if(len > 10){
            System.out.println(0);
            return;
        }else{
            int num[] = new int[10];
            for(int i = 0; i < len; i++){
                num[input.charAt(i) - '0']++;
            }
            for(int i = 0; i < len; i++){
                if((input.charAt(i) - '0') != num[i]){
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(1);
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
