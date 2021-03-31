import java.util.*;
public class Solution{
    ListNode list = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = len(head);
        list = head;
        return helper(0, len - 1);
    }
    public TreeNode helper(int l, int r){
        if(l > r) return null;
        int mid = l + (r - l)/2;
        TreeNode left = helper(l, mid-1);
        TreeNode root = new TreeNode(list.val);
        list = list.next;
        TreeNode right = helper(mid+1, r);
        root.left = left;
        root.right = right;
        return root;
    }
    public int len(ListNode r){
        int ret = 0;
        while(r != null){
            r = r.next;
            ret++;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
