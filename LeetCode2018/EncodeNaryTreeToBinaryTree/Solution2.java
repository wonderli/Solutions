import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
};
class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;

        TreeNode result = new TreeNode(root.val);
        if(root.children.size() > 0){
            result.left = encode(root.children.get(0));
        }
        TreeNode curr = result.left;
        for(int i=1;i <root.children.size(); i++){
            curr.right = encode(root.children.get(i));
            curr = curr.right;
        }
        return result;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null){
            return null;
        }

        Node result = new Node(root.val, new ArrayList<>());
        TreeNode curr = root.left;
        while(curr != null){
            result.children.add(decode(curr));
            curr = curr.right;
        }
        return result;
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
