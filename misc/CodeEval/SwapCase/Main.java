import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String line){
        int len = line.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            char c = line.charAt(i);
            if(Character.isAlphabetic(c)){
                if(Character.isLowerCase(c)){
                    c = Character.toUpperCase(c);
                    sb.append(c);
                }else if(Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
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
