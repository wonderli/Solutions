import java.util.*;
import java.io.*;
public class Main {
    public static void solve(String[] A){
        int i = 0;
        int j = 1;
        while(j < A.length){
            if(A[i].equals(A[j])) j++;
            else {
                i++;
                String tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                j++;
            }
        }
        for(int k = 0; k < i+1; k++){
            System.out.print(A[k]);
            if(k != i) System.out.print(",");
        }
        System.out.println();
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] sa = line.split(",");
                solve(sa);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
