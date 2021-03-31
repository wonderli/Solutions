import java.util.*;
public class Solution{
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator(){
            public int compare(Object o1, Object o2){
                ListNode a = (ListNode)o1;
                ListNode b = (ListNode)o2;
                return a.val - b.val;
            }
        });
        for(ListNode e: lists){
            if(e != null){
                pq.add(e);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(!pq.isEmpty()){
            ListNode e = pq.poll();
            p.next = e;
            e = (e != null) ? e.next : null;
            if(e != null){
                pq.add(e);
            }
            p = p.next;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
