// Given an unsorted integer array, find the first missing positive integer.
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
// Your algorithm should run in O(n) time and uses constant space. 
import java.util.*;
public class Solution{
    public int firstMissingPositive(int[] A) {
        if(A.length == 0) return 1;
        int i = 0;
        for(i = 0; i < A.length; i++){
            while(A[i] > 0 && A[i] < A.length && A[i] != A[A[i]]){
                int tmp = A[i];
                A[i] = A[A[i]];
                A[tmp] = tmp;
            }
        }
        for(i = 1; i < A.length; i++){
            if(A[i] != i){ 
                return i;
            }
        }
        if(A[0] != A.length) return A.length;
        return A.length + 1;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int A[] = {2,1};
        System.out.println(s.firstMissingPositive(A));

    }
}
