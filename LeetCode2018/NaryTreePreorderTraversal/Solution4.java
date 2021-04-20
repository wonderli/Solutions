import java.util.*;
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result);
        return result;
    }
    private void helper(Node root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        List<Node> children = root.children;
        for(Node e : children){
            helper(e, result);
        }
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
}