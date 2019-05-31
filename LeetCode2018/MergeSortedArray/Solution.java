import java.util.*;
public class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length == 0) return;
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n -1;
        while(p1 >= 0 && p2 >= 0){
            if(nums2[p2] > nums1[p1]){
                nums1[i] = nums2[p2];
                p2--;
            }else {
                nums1[i] = nums1[p1];
                p1--;
            }
            i--;
        }
        if(p1 < 0 && p2 >= 0){
            while(i >= 0 && p2 >= 0){
                nums1[i] = nums2[p2];
                p2--;
                i--;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {2,5,6};
        //int[] n1 = {-1, -1, 0, 0, 0, 0};
        //int[] n2 = {-1, 0};
        //sol.merge(n1, 4, n2, 2);
        sol.merge(n1, 3, n2, 3);
        System.out.println(Arrays.toString(n1));
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
