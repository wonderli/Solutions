import java.util.*;
public class Solution2{
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }
    public void helper(Node root){
        if(root == null) return;
        helper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        helper(root.right);
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
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
