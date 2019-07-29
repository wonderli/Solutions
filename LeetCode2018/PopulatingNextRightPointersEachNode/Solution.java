import java.util.*;
public class Solution{
    public Node connect(Node root) {
        if(root == null) return null;
        Node curr = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Node> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node n = queue.poll();
                Node left = n.left;
                Node right = n.right;
                level.add(n);
                if(left  != null){
                    queue.add(left);
                }
                if(right != null){
                    queue.add(right);
                }
            }
            for(int i = 0; i < level.size() - 1; i++){
                int j = i+1;
                Node first = level.get(i);
                Node second = level.get(j);
                first.next = second;
            }
        }
        return root;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
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
}
