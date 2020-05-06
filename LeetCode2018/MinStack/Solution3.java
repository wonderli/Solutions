import java.util.*;
public class Solution3{
    private ListNode head;
    public void push(int x){
        if(head == null){
            head = new ListNode(x, x, null);
        }else {
            head = new ListNode(x, Math.min(head.min, x), head);
        }
    }
    public void pop(){
        head = head.next;
    }
    public int top(){
        return head.val;
    }
    public int getMin(){
        return head.min;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    int min;
    ListNode next;
    ListNode(int x, int min, ListNode next) { val = x; this.min = min; this.next = next; }
}
