import java.util.*;
public class Solution{
    public Node connect(Node root) {
        if(root == null) return null;
        List<List<Node>> lists = new ArrayList<>();
        List<Node> curr = new ArrayList<>();
        curr.add(root);
        while(!curr.isEmpty()){
            List<Node> next = new ArrayList<>();
            for(int i = 0; i < curr.size(); i++){
                Node n = curr.get(i);
                if(n.left != null){
                    next.add(n.left);
                }
                if(n.right != null){
                    next.add(n.right);
                }
            }
            lists.add(curr);
            curr = next;
        }
        for(List<Node> l : lists){
            Node prev = l.get(0);
            for(int i = 1; i < l.size(); i++){
                Node n = l.get(i);
                prev.next = n;
                prev = n;
            }
        }

        return root;
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
