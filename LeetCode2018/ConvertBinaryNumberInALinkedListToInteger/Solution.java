import java.util.*;
public class Solution{
    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
        ListNode curr = head;
        int res = 0;
        while(curr != null){
            int a = curr.val;
            res = res * 2 + a;
            curr = curr.next;
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

