import java.util.*;
public class Solution2{
    public int largestRectangleArea(int[] heights) {
           Stack<Integer> stack = new Stack<>();
           stack.push(-1);
           int maxArea = 0;
           int n = heights.length;
           for(int i = 0; i < n; i++){
               while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                   maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));        
               }
               stack.push(i);
           }
           while(stack.peek() != -1){
               maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
           }
        
           return maxArea;
       }
    
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
