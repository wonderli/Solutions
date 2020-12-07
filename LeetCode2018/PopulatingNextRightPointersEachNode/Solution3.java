import java.util.*;
public class Solution3{
	public Node connect(Node root) {
	        Node p = root;
	        while(p != null && p.left != null){
	            Node curr = p;
	            while(curr != null){
	                curr.left.next = curr.right;
	                curr.right.next = curr.next == null ? null : curr.next.left;
	                curr = curr.next;
	            }
	            p = p.left;
	        }
	        return root;
	    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
