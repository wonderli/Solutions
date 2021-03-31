import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) {
        String s = args[0];
        File f = null;
        try{
            f = new File(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(f.length());

    }
}
