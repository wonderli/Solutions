//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) return ret;
        int len = num.length;
        int i = 0;
        int j = 0;
        int k = 0;
        Arrays.sort(num);
        for(i = 0; i < len - 2; i++){
            if(i > 0 && num[i] == num[i-1]) continue;
            j = i + 1;
            k = len - 1;
            while(j < k){
                if(num[k] == -1 * (num[i] + num[j])){
                    ArrayList<Integer> e = new ArrayList<Integer>();
                    e.add(num[i]);
                    e.add(num[j]);
                    e.add(num[k]);
                    ret.add(e);
                    k--;
                    j++;
                    while(k > j && num[k] == num[k+1]) k--;
                    while(j < k && num[j] == num[j-1]) j++;
                }else if(num[k] > -1 * (num[i] + num[j])){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {0,0,0};  
        ArrayList<ArrayList<Integer>> ret = sol.threeSum(A);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }
    }
}
