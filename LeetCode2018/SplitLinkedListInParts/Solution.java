import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = count(head);
        int m = len/k;
        int rem = len % k;
        ListNode[] result = new ListNode[k];
        ListNode curr = head;
        
        for(int j = 0; j < k;j ++){
            result[j] = curr;
            ListNode prev = null;
            
            for(int i = 0; i < m + (j < rem ? 1 : 0); i++){
                prev = curr;
                curr = curr.next;
            }

            if(prev != null){
                prev.next = null;    
            }
        }
        return result;
        
    }
    private int count(ListNode node){
        int count = 0;
        while(node != null){
            node = node.next;
            count++;
        }
        return count;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}
