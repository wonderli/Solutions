import java.util.*;
public class Solution3{
//    public int maxDepth(Node root) {
//        if(root == null) return 0;
//        int max = 0;
//        for(Node n : root.children){
//            max = Math.max(max, maxDepth(n));
//        }
//        return max+1;
//    }
    public int maxDepth(Node root){
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                for(Node n : curr.children){
                    queue.add(n);
                }
            }
            count++;
        }
        return count;
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
