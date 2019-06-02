import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution sol = new Solution();
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
class ListNode {
    int val;
    int min;
    ListNode next;
    ListNode(int x, int min, ListNode next) { val = x; this.min = min; this.next= next; }
}
class MinStack {
    private ListNode head;

    public void push(int x) {
        if(head == null){
            head = new ListNode(x, x, null);
        }else {
            head = new ListNode(x, Math.min(head.min, x), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
