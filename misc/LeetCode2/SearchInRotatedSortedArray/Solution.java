import java.util.*;
public class Solution{
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        int len = A.length;
        int l = 0;
        int r = len - 1;
        return helper(l, r, A, target);
    }
    public int helper(int l, int r, int A[], int target){
        if(l > r) return -1;
        int mid = l + (r - l)/2;
        if(A[mid] == target) return mid;
        else if(A[l] <= A[mid]){
            if(A[l] <= target && target <= A[mid]){
                return helper(l, mid-1, A, target);
            }else return helper(mid+1, r, A, target);
        }else{
            if(A[mid] <= target && target <= A[r]){
                return helper(mid+1, r, A, target);
            }else return helper(l, mid-1, A, target);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
