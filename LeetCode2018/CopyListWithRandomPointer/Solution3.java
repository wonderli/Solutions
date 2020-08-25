import java.util.*;
public class Solution3{
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);
        while(oldNode != null){
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
    }
    public Node getClonedNode(Node n){
        if(n == null) return null;
        if(map.containsKey(n)) return map.get(n);
        Node newNode = new Node(n.val);
        map.put(n, newNode);
        return newNode;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
