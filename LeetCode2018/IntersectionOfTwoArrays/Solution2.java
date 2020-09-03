import java.util.*;
public class Solution2{
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0;
        int r = 0;
        Set<Integer> set = new HashSet<>();
        while(l < nums1.length && r < nums2.length){
            if(nums1[l] < nums2[r]){
                l++;
            }else if(nums1[l] > nums2[r]){
                r++;
            }else if(nums1[l] == nums2[r]){
                set.add(nums1[l]);
                l++;
                r++;
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
