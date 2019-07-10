import java.util.*;
public class Solution{
	public int maxDepth(Node root) {
	        if(root == null) return 0;
	        Queue<Node> curr = new LinkedList<>();
	        curr.add(root);
	        int depth = 0;
	        Queue<Node> next = new LinkedList<>();
	        while(!curr.isEmpty() ){
	            Node currNode = curr.poll();
	            if(currNode != null){
	                List<Node> children = currNode.children;
	                if(children != null){
	                    next.addAll(children);
	                }
	            }
	            if(curr.isEmpty()){
	                curr = next;
	                next = new LinkedList<>();
	                depth++;
	            }
	        }
	        return depth;
	    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
