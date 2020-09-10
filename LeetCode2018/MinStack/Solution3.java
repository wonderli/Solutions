import java.util.*;
public class Solution3{
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    int min;
    ListNode next;
    ListNode(int x, int min, ListNode next) { val = x; this.min = min; this.next= next; }
}
class MinStack {
    ListNode head;
    public MinStack(){
        head = null;
    }
    public void pop(){
        head = head != null ? head.next : null;
    }
    public int top(){
        return head.val;
    }
    public void push(int x){
        if(head == null){
            head = new ListNode(x, x, null);
        }else {
            head = new ListNode(x, Math.min(head.min, x), head);
        }
    }
    public int getMin(){
        return head.min;
    }

}
