/* Head ends here */
import java.util.*;
public class Solution2 {

    static void partition(int[] ar) {
        int len = ar.length;
        if(ar.length < 2){
            printArray(ar);
            return;
        }
        int p = ar[0];
        ArrayList<Integer> large = new ArrayList<Integer>();
        ArrayList<Integer> small = new ArrayList<Integer>();
        for(int i = 0; i < len; i++){
            if(ar[i] < p){
                small.add(ar[i]);
            }else{
                large.add(ar[i]);
            }
        }
        small.addAll(large);
        for(int i = 0; i < len; i++){
            ar[i] = small.get(i);
        }
        printArray(ar);
    }   

    /* Tail starts here */

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
        }
        partition(ar);
    }    
}

