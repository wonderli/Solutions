//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
import java.util.*;
public class Solution{
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0) return null;
        if(lists.size() == 1) return lists.get(0);
        ListNode prev = lists.get(0);
        for(int i = 1; i < lists.size(); i++){
            ListNode curr = lists.get(i);
            prev = merge2Lists(prev, curr);
        }
        return prev;
    }
    public ListNode merge2Lists(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;
        ListNode root = null;
        if(a.val <= b.val){
            root = a;
            root.next = merge2Lists(a.next, b);
        }else{
            root = b;
            root.next =merge2Lists(a, b.next);
        }
        return root;
    }
    public static void printList(ListNode n){
        if(n == null) return ;
        while(n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ListNode a = new ListNode(0);
        a.next = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode root = sol.merge2Lists(a, b);
        printList(root);
        
    }
}
