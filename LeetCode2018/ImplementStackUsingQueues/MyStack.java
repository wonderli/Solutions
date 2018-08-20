import java.util.*;
class MyStack {
    Queue<Integer> q;
    Queue<Integer> q1;
    Queue<Integer> q2;
    boolean isQueue1;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        isQueue1 = true;
        q = q1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) throw new NoSuchElementException();
        int size = q.size();
        for(int i = 0; i < size-1; i++){
            int e = q.poll();
            if(isQueue1){
                q2.add(e);
            } else {
                q1.add(e);
            }
        }
        int result = q.poll();
        isQueue1 = !isQueue1;
        q = isQueue1 ? q1 : q2;
        return result;
    }

    /** Get the top element. */
    public int top() {
        int result = pop();
        q.add(result);
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
    public static void main(String args[]){
        MyStack stk = new MyStack();
        stk.push(1);
        stk.push(2);
        System.out.println(stk.pop());
        stk.push(3);
        System.out.println(stk.top());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.empty());


        System.out.println(stk.q2);
    }
}
