import java.util.*;
public class Solution2{
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = queue.poll();
            if(prev.left != null) queue.add(prev.left);
            if(prev.right != null) queue.add(prev.right);
            for(int i = 0; i < size - 1; i++){
                Node curr = queue.poll();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                prev.next = curr;
                prev = curr;
            }
        }
        return root;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
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
};
