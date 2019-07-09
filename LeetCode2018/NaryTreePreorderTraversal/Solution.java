import java.util.*;
public class Solution{
    public List<Integer> preorder(Node root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        List<Node> children = root.children;
        for(Node node : children){
            List<Integer> curr = preorder(node);
            list.addAll(curr);
        }
        return list;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
