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
public class Solution3{
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int fac[] = new int[n];
        fac[0] = 1;
        for(int i = 1; i < n; i++){
            fac[i] = fac[i-1] * i;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        --k;
        for(int i = n - 1; i >= 1; i--){
           int idx = k/fac[i];
           sb.append(list.get(idx));
           list.remove(idx);
           k = k % fac[i];
        }
        sb.append(list.get(0));
        return sb.toString();
    }

    public static void main(String args[]){
        Solution3 sol = new Solution3();
        int n = 3;
        for(int i = 1; i <= 6; i++){
            System.out.println(sol.getPermutation(n,i));
        }
    }
}
