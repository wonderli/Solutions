import java.util.*;
public class Solution2{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null) return;
        int i = m + n - 1;
        int p = m - 1;
        int q = n - 1;
        while(p >= 0 && q >= 0){
            int a = nums1[p];
            int b = nums2[q];
            if(a <= b){
                nums1[i] = b;
                q--;
            }else {
                nums1[i] = a;
                p--;
            }
            i--;
        }
        if(p < 0 && q >= 0){
            while(i >= 0 && q >= 0){
                nums1[i] = nums2[q];
                q--;
                i--;
            }
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
