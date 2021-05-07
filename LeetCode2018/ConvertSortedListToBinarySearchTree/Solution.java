import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode curr = null;
    public TreeNode sortedListToBST(ListNode head) {
        int n = get(head);
        curr = head;
        return convert(0, n-1);
    }
    
    private TreeNode convert(int l, int r){
        if(l > r) return null;
        int mid = l + (r - l)/2;
        TreeNode left = convert(l, mid-1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        root.left = left;
        root.right = convert(mid+1, r);
        return root;
        
    }
    private int get(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}
