import java.util.*;
public class Solution3{
	
	public ListNode mergeKLists(ListNode[] lists) {
	        if(lists.length == 0) return null;
	        int len = lists.length;
	        return helper(lists, 0, len - 1);
	    }
	    public ListNode helper(ListNode[] lists, int start, int end){
	        if(start > end) {
	            return null;
	        }
	        if(start == end){
	            return lists[start];
	        }
	        int mid = start + (end - start)/2;
	        ListNode a = helper(lists, start, mid);
	        ListNode b = helper(lists, mid+1, end);
        
	        ListNode dummy = new ListNode();
	        ListNode curr = dummy;
	        while(a != null && b != null){
	            curr.next = a.val < b.val ? a : b;
	            if(a.val < b.val){
	                a = a.next;
	            }else{
	                b = b.next;
	            }
	            curr = curr.next;
	        }
	        if(a != null){
	            curr.next = a;
	        }else if(b != null){
	            curr.next = b;
	        }
	        return dummy.next;
	    }
		
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}
