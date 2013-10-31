import java.util.*;
public class Solution{
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) return false;
        int len = A.length;
        return helper(0, len-1, A, target);
    }
    public boolean helper(int l, int r, int A[], int target){
        if(l > r) return false;
        int mid = l + (r - l)/2;
        if(A[mid] == target) return true;
        else if(A[l] <= A[mid]){
            if(A[l] <= target && target <= A[mid]){
                return helper(l, mid-1, A, target);
            }else return helper(l, mid-1, A, target) || helper(mid+1, r, A, target);
        }else{
            if(A[mid] <= target && target <= A[r]){
                return helper(mid+1, r, A, target);
            }else return helper(l, mid-1, A, target) || helper(mid+1, r, A, target);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
