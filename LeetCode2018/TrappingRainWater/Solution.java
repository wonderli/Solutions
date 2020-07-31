import java.util.*;
public class Solution{
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for(int i = 1; i < len; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for(int i = len - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for(int i = 1; i < len - 1; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
