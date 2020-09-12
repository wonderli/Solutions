import java.util.LinkedList;
import java.util.Queue;

class MyStack2 {
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q.size();
        for(int i = 0; i < size - 1; i++){
            q.add(q.poll());
        }
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        int val = pop();
        q.add(val);
        return val;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */