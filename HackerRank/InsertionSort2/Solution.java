/* Head ends here */
import java.util.*;
public class Solution {

    static void insertionSort(int ar[]){
        int len = ar.length;
        if(len == 1){
            printArray(ar);
            return;
        }
        int j = 1; 
        while(j < len){
            int key = ar[j];
            int i = j - 1;
            while(i >= 0 && ar[i] > key){
                ar[i+1] = ar[i];
                i = i-1;
            }
            ar[i+1] = key;
            printArray(ar);
            j++;
        }
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
        insertionSort(ar);
    }    
}
