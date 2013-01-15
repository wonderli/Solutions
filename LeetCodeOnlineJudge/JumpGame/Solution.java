// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
// For example:
// A = [2,3,1,1,4], return true.
//
// A = [3,2,1,0,4], return false. 
public class Solution{
     public boolean canJump(int[] A) {
         if(A == null) return false;
         return helper(A, 0);
     }
     public boolean helper(int[] A, int i){
         if(i == A.length - 1) return true;
         if(i >= A.length ) return true;
         if(i < A.length - 1 && A[i] == 0) return false;
         return helper(A, i + A[i]);
     }
    public static void main(String args[]){
        //int A[] = {2, 3, 1, 1, 4};
        int A[] = {3, 2, 1, 0, 4};
        Solution s = new Solution();
        System.out.println(s.canJump(A));


    }
}
