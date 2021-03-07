import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        populateStack2();
        return stack2.pop();
    }
    private void populateStack2(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int x = stack1.pop();
                stack2.push(x);
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        populateStack2();
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}