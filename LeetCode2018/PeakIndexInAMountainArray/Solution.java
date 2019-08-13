import java.util.*;
public class Solution{
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length < 3) return -1;
        int n = A.length;
        int l = 0;
        int r = n - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(A[mid] > A[mid-1] && A[mid] < A[mid+1]){
                return mid;
            } else if(A[mid] > A[mid - 1] || A[mid] < A[mid+1]){
                l++;
            }else if(A[mid] < A[mid-1] || A[mid] > A[mid+1]){
                r--;
            }
        }
        return l;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
		int[] A = {0, 1, 0};
		System.out.println(sol.peakIndexInMountainArray(A));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
