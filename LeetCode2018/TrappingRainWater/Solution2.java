import java.util.*;
public class Solution2{
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        while(current < height.length){
            while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                int top = stack.peek();
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                res += distance * boundedHeight;
            }
            stack.push(current);
            current++;
        }
        return res;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(sol.trap(arr));
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
