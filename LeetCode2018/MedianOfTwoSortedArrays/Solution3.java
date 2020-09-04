import java.util.*;
public class Solution3{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int med1 = 0;
        int med2 = 0;
        int i = 0;
        int j = 0;
        for(int index = 0;index<= (m + n)/2; index++){
            med1 = med2;
            if(i == nums1.length){
                med2 = nums2[j];
                j++;
            }else if(j == nums2.length){
                med2 = nums1[i];
                i++;
            }else if(nums1[i] < nums2[j]){
                med2 = nums1[i];
                i++;
            }else{
                med2 = nums2[j];
                j++;
            }
        }
        if((nums1.length +nums2.length)%2 == 0){
            return (double)(med1 + med2)/2;
        }
        return med2;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
