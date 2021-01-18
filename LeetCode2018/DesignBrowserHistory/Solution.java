import java.util.*;
public class Solution{
	private class BrowserHistory {

	    Deque<String> stack1;
	    Deque<String> stack2;
	    String homepage;
	    public BrowserHistory(String homepage) {
	        stack1 = new ArrayDeque<>();
	        stack2 = new ArrayDeque<>();
	        stack1.push(homepage);
	        this.homepage = homepage;
	    }
    
	    public void visit(String url) {
	        stack2.clear();
	        stack1.push(url);
	    }
    
	    public String back(int steps) {
	        while(!homepage.equals(stack1.peek()) && steps > 0){
	            String s = stack1.pop();
	            stack2.push(s);
	            steps--;
	        }
	        return stack1.peek();
	    }
    
	    public String forward(int steps) {
	        while(!stack2.isEmpty() && steps >0){
	            String s = stack2.pop();
	            stack1.push(s);
	            steps--;
	        }
	        return stack1.peek();
	    }
	}

	/**
	 * Your BrowserHistory object will be instantiated and called as such:
	 * BrowserHistory obj = new BrowserHistory(homepage);
	 * obj.visit(url);
	 * String param_2 = obj.back(steps);
	 * String param_3 = obj.forward(steps);
	 */
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
