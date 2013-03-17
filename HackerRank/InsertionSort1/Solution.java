/* Head ends here */
import java.util.*;
public class Solution {

    static void insertionSort(int[] ar) {
        int len = ar.length;
        int num = ar[len - 1];
        int i = len - 1;
        if(ar[i] > ar[i-1]){
            printArray(ar);
            return;
        }
        while(i >= 1){
            if(ar[i-1] > num){
                ar[i] = ar[i-1];
            }else{
                ar[i] = num;
            }
            printArray(ar);
            if(ar[i] > ar[i-1]){
                break;
            }
            i--;
        }
        if(ar[0] > num){
            ar[0] = num;
            printArray(ar);
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
