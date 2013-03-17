/* Head ends here */
import java.util.*;
public class Solution {

    static void partition(int[] ar) {
        int len = ar.length;
        if(ar.length < 2){
            printArray(ar);
            return;
        }
        int p = ar[0];
        int i = 1;
        int j = -1;
        while(i < len){
            if(ar[i] > p){
                i++;
            }else{
                j++;
                int tmp = ar[j];
                ar[j] = ar[i];
                ar[i] = tmp;
                i++;
            }
        }
        ar[j+1] = p;
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

