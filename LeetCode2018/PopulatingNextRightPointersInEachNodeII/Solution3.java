import java.util.*;
public class Solution3{
    public Node connect(Node root){
        Node dummy = new Node(0);
        Node pre = dummy;

        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                pre.next= curr.left;
                pre = pre.next;
            }
            if(curr.right != null){
                pre.next = curr.right;
                pre = pre.next;
            }
            curr = curr.next;
            if(curr == null){
                curr = dummy.next;
                pre = dummy;
                dummy.next = null;
            }
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
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
