import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
	public Node(int val, Node prev, Node next, Node child){
		this.val = val;
		this.prev = prev;
		this.next = next;
		this.child = child;
	}
};


class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node dummy = new Node(0, null, head, null);
        dfs(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }
    private Node dfs(Node prev, Node curr){
        if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        Node tmp = curr.next;
        
        Node tail = dfs(curr, curr.child);
        curr.child = null;
        return dfs(tail, tmp);
    }
}
