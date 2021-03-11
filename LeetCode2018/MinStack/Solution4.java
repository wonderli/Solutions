import java.util.*;
class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<int[]> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || x < min.peek()[0]){
            min.push(new int[]{x, 1});
        }else if(x == min.peek()[0]){
            min.peek()[1]++;
        }
    }
    
    public void pop() {
        int v = stack.pop();
        if(v == min.peek()[0]){
            min.peek()[1]--;
            if(min.peek()[1] == 0){
                min.pop();
            } 
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
