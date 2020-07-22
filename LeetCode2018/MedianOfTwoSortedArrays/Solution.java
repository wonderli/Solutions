import java.util.*;
public class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        boolean isOdd = (m + n) % 2 == 1;
        int count = 0;
        int target = isOdd ? (m + n)/2 + 1 : (m + n)/2;
        double res = 0;
        int last = 0;
        double first = 0;
        double second = 0;
        while(i < m || j < n){
        	int a = i < m ? nums1[i] : Integer.MAX_VALUE;
        	int b = j < n ? nums2[j] : Integer.MAX_VALUE;
            if(a < b){
                last = a;
                i++;
                count++;
            }else{
                last = b;
                j++;
                count++;
            }
            if(isOdd && (count == target)) {
                if(isOdd) {
                    res = (double)last;
                }
            }else if(!isOdd){
                if (count == target){
                    first = (double) last;
                }else if(count == target + 1){
                    second = (double) last;
                    res = (first + second)/2.0;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println(sol.findMedianSortedArrays(a,b));
        int[] c = {1, 2};
        int[] d = {3, 4};
        System.out.println(sol.findMedianSortedArrays(c,d));
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
