//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"

//Given n and k, return the kth permutation sequence.
import java.util.*;
public class Solution2{
    public String getPermutation(int n, int k) {
        boolean mark[] = new boolean[n];
        StringBuilder sb = new StringBuilder();
        int ans[] = new int[n];
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * i;
        }
        for(int i = n - 1; i >= 0; i--){
            int s = 1;
            while(k > ans[i]){
                s++;
                k -= ans[i];
            }
            for(int j = 0; j < n; j++){
                if(j + 1 <= s &&  mark[j]){
                    s++;
                }
            }
            mark[s-1] = true;
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int n = 3;
        for(int i = 1; i <= 6; i++){
            System.out.println(sol.getPermutation(n,i));
        }
    }
}
