//next permutation
//prev permutation
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
    public static String prevPermutation(String str){
        int len = str.length();
        String ret = null;
        char s[] = str.toLowerCase().toCharArray();
        int j = len - 1;
        int k = len - 1;
        while(j > 0 && s[j] < s[j-1]){
            j--;
        }
        if(j < 0) return ret;
        k = len - 1;
        while(k > 0 && s[k] < s[j]){
            k--;
        }
        char temp = s[j];
        s[j] = s[k];
        s[k] = temp;
        Arrays.sort(s, j+1, len);
        ret = String.valueOf(s);
        return ret;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = null;
        if(sc.hasNext()){
            input = sc.next();
        }
        String next = nextPermutation(input);
        System.out.println(next);
        String prev = prevPermutation(input);
        System.out.println(prev);
//        while(next != null){
//            System.out.println();
//            next = nextPermutation(next);
//            System.out.println(next);
//            System.out.println(prevPermutation(next));
//            System.out.println();
//        }
    }
}
