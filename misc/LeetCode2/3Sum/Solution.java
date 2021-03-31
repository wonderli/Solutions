import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if(num == null || num.length == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int len = num.length;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < len; i++){
            if( i > 0 && num[i] == num[i-1]) continue;
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                if(num[i] + num[j] + num[k] == 0){
                    ArrayList<Integer> curr = new ArrayList<Integer>();
                    curr.add(num[i]);
                    curr.add(num[j]);
                    curr.add(num[k]);
                    ret.add(curr);
                    j++;
                    k--;
                    while(j < k && num[j] == num[j-1]) j++;
                    while(j < k && num[k] == num[k+1]) k--;
                }else if(num[i] + num[j] + num[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ret;
    }
    public static void print(ArrayList<ArrayList<Integer>> a){
        for(ArrayList<Integer> e : a){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {-1, 0, 1, 2, -1, -4};
        print(sol.threeSum(num));
    }
}
