import java.util.*;
public class Solution2{
    public int maxDepth(Node root){
        if(root == null) return 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int depth = 0;
        while(!stack.empty()){
            Pair current = stack.pop();
            Node curr = current.node;
            int currDepth = current.value;
            if(curr != null){
                depth = Math.max(depth, currDepth);
                for(Node c : curr.children){
                    stack.push(new Pair(c, currDepth + 1));
                }
            }
        }
        return depth;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class Pair {
    Node node;
    int value;
    public Pair(Node node, int value){
        this.node = node;
        this.value = value;
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
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
