import java.util.*;
public class Solution{
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node n = new Node(insertVal);
            n.next = n;
            return n;
        }
        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;
        do{
            if(prev.val <= insertVal && insertVal <= curr.val){
                toInsert = true;
            }else if(prev.val > curr.val){
                if(insertVal >= prev.val || insertVal <= curr.val){
                    toInsert =true;
                }
            }
            if(toInsert){
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;
        }while(prev != head);
        prev.next = new Node(insertVal, curr);
        return head;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
