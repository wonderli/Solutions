import java.util.*;
public class Solution3{
   // public List<Integer> postorder(Node root) {
   //     List<Integer> ret = new ArrayList<>();
   //     if(root == null) return ret;
   //     helper(root, ret);
   //     return ret;
   // }
   // public void helper(Node root, List<Integer> ret){
   //     if(root == null) return;
   //     List<Node> children = root.children;
   //     for(Node n : children){
   //         helper(n, ret);
   //     }
   //     ret.add(root.val);
   // }
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            ret.add(curr.val);
            List<Node> children = curr.children;
            for(Node n : children){
                stack.push(n);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
