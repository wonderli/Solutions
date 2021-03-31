import java.util.*;
import java.io.*;
public class Main {
    public static void solve(int array[]){
        int A = array[0];
        int B = array[1];
        int N = array[2];
        for(int i = 1; i <= N; i++){
            if(i%A == 0 && i%B == 0){
                System.out.print("FB");
            }else if(i%A == 0 && i%B != 0){
                System.out.print("F");
            }else if (i%A != 0 && i%B == 0){
                System.out.print("B");
            }else{
                System.out.print(i);
            }
            if(i != N){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(" ");
                int array[] = new int[3];
                for(int i = 0; i < 3; i++){
                    array[i] = Integer.parseInt(lineArray[i]);
                }
                solve(array);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
