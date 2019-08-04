import java.util.*;
public class Solution{
    public Node connect(Node root) {
        if(root == null) return null;
        helper(root, null);
        return root;
    }
    public void helper(Node node, Node parent){
        if(node == null) return;
        if(parent != null) {
            if(node == parent.left && parent.right != null){
                node.next = parent.right;
            }else{
                Node pNext = parent.next;
                node.next = null;
                while(pNext != null){
                    if(pNext.left != null){
                        node.next = pNext.left;
                        break;
                    }
                    if(pNext.right != null){
                        node.next = pNext.right;
                        break;
                    }
                    pNext = pNext.next;
                }
            }
        }else {
            node.next = null;
        }

        helper(node.right, node);
        helper(node.left, node);
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
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
