import java.util.*;
public class Solution3{
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0;
        int r = 0;
        List<Integer> set = new ArrayList<>();
        while(l < nums1.length && r < nums2.length){
            if(nums1[l] < nums2[r]){
                l++;
            }else if(nums1[l] > nums2[r]){
                r++;
            }else if(nums1[l] == nums2[r]){
                set.add(nums1[l]);
                int val = nums1[l];
                l++;
                while(l < nums1.length && nums1[l] == val) l++;
                r++;
                while(r < nums2.length && nums2[r] == val) r++;
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
