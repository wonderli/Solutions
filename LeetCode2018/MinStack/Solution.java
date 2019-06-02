import java.util.*;
public class Solution{
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
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class MinStack {
    private PriorityQueue<ListNode> queue;
    private Deque<ListNode> stack;

    /** initialize your data structure here. */
    public MinStack() {
        queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
                return n1.val < n2.val? -1 : 1;
            }
        });
        stack = new LinkedList<>();
    }

    public void push(int x) {
        ListNode n = new ListNode(x);
        stack.push(n);
        queue.add(n);
    }

    public void pop() {
        ListNode n = stack.pop();
        queue.remove(n);
    }

    public int top() {
        ListNode n = stack.peek();
        return n != null ? n.val : 0;
    }

    public int getMin() {
        ListNode n = queue.peek();
        return n!= null ? n.val : 0;
    }
}
