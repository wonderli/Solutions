// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
//
// For example,
// Given sorted array A = [1,1,1,2,2,3],
//
// Your function should return length = 5, and A is now [1,1,2,2,3]. 
import java.util.*;
public class Solution{
    public int removeDuplicates(int[] A) {
        if(A.length <= 2) return A.length;
        int len = A.length;
        int i = 2;
        int j = 2;
        while(j < len){
            if(A[j] != A[i - 1] || A[j] != A[i - 2]){
                A[i++] = A[j];
            }
            j++;
        }
        return i;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {1, 1, 1, 1, 3, 3};
        System.out.println(Arrays.toString(A));
        System.out.println(sol.removeDuplicates(A));
        System.out.println(Arrays.toString(A));
    }
}
