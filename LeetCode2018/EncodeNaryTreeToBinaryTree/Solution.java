import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
};
class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        TreeNode t = new TreeNode(root.val);
        TreeNode pre = null;
        for(Node n : root.children){
            TreeNode last = encode(n);
            if(pre == null) t.left = last;
            else pre.right = last;
            pre = last;
        }
        return t;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        return preorder(root, new ArrayList<>());
    }
    private Node preorder(TreeNode t, List<Node> container){
        if(t == null) return null;

        Node n = new Node(t.val);
        container.add(n);
        n.children = new ArrayList<>();
        preorder(t.left, n.children);
        preorder(t.right, container);
        return n;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
