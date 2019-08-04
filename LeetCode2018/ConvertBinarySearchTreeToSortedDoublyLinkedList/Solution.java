import java.util.*;
public class Solution{
    public Node treeToDoublyList(Node root) {
        List<Node> list = new ArrayList<>();
        helper(root, list);
        return link(list);
    }
    public void helper(Node root, List<Node> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }
    public Node link(List<Node> list){
        if(list.isEmpty()) return null;
        Node node = list.get(0);
        Node prev = node;
        for(int i = 1; i < list.size(); i++){
            Node curr = list.get(i);
            curr.left = prev;
            prev = curr;
        }
        for(int i = 0; i < list.size() - 1; i++){
            Node curr = list.get(i);
            curr.right = list.get(i+1);
        }
        int len = list.size();
        if(list.size() >= 1){
            Node last = list.get(len - 1);
            node.left = last;
            last.right = node;
        }
        return node;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        Node n = new Node(1, null, null);
        sol.treeToDoublyList(n);
    }
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
