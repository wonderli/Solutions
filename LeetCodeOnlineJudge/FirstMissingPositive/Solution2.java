// Given an unsorted integer array, find the first missing positive integer.
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
// Your algorithm should run in O(n) time and uses constant space. 
import java.util.*;
public class Solution2{
    public int firstMissingPositive(int[] A) {
        if(A.length == 0) return 1;
        for(int i = 0; i < A.length; i++){
            while(A[i] > 0 && A[i] <= A.length && A[i] != i+1){
                int tmp = A[i];
                if(A[tmp - 1] != tmp)
                    swap(A, i, A[tmp - 1]);
                else
                    break;
            }
        }
        for(int i = 1; i < A.length; i++){
            if(A[i] != i+1){ 
                return i+1;
            }
        }
        return A.length + 1;
    }
    public static void swap(int A[], int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public static void main(String args[]){
        Solution2 s = new Solution2();
        int A[] = {2,1};
        System.out.println(s.firstMissingPositive(A));

    }
}
