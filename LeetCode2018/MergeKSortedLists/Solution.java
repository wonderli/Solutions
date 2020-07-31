import java.util.*;
public class Solution{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        Comparator<ListNode> comparator = new Comparator<>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        };
        Queue<ListNode> pq = new PriorityQueue<>(comparator);
        for(ListNode l : lists){
            if(l != null){
                pq.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr  = head;
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
            ListNode next = curr.next;
            if(next != null){
                pq.add(next);
            }
        }
        return head.next;
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
