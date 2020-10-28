import java.util.*;
public class Solution2{
	
	public ListNode detectCycle(ListNode head) {
	        if(head == null) return null;
	        ListNode curr = head;
	        Set<ListNode> visited = new HashSet<>();
	        while(curr != null && !visited.contains(curr)){
	            visited.add(curr);
	            curr = curr.next;
	        }
	        if(curr == null) {
	            return null;
	        }
	        return curr;
	    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
