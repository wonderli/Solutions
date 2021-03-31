import java.util.*;
import java.io.*;
public class Main {
    public static void solve(int num){
        boolean A[] = new boolean[num+1];
        for(int i = 0; i <= num; i++){
            A[i] = true;
        }
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(A[i] == true){
                for(int j = i * i; j <= num; j = j + i){
                    A[j] = false;
                }
            }
        }
        int pos = 0;
        for(int i = num; i >= 0; i--){
            if(A[i] == true){
                pos = i;
                break;
            }
        }
        for(int i = 2; i <= num; i++){
            if(A[i] == true){
                System.out.print(i);
                if(i != pos) System.out.print(",");
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
                int num = Integer.parseInt(line);
                solve(num);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
