//next permutation
import java.util.*;
public class Sol{
    public static String nextPermutation(String s){
        String ret = null;
        char sArray[] = s.toLowerCase().toCharArray();
        int len = s.length();
        int i = 0;
        int j = len - 2;
        int k = len - 1;
        while(j >= 0 && sArray[j] > sArray[j+1]){
            j--;
        }
        if(j < 0){
            return ret;
        }
        while(sArray[k] < sArray[j]){
                k--;
        }
        char temp = sArray[k];
        sArray[k] = sArray[j];
        sArray[j] = temp;
        int low = j + 1;
        int high = len - 1;
        while(low < high){
            temp = sArray[low];
            sArray[low] = sArray[high];
            sArray[high] = temp;
            low++;
            high--;
        }
        ret = String.valueOf(sArray);
        return ret;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = null;
        if(sc.hasNext()){
            input = sc.next();
        }
        System.out.println(nextPermutation(input));
    }
}
