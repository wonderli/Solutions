import java.util.*;
public class Solution3{
	public int trap(int[] height) {
			if (height == null || height.length == 0)
				return 0;
			int left = 0;
			int right = height.length - 1;
			int leftMax = 0;
			int rightMax = 0;
			int res = 0;
			while (left < right) {
				if (height[left] > leftMax) {
					leftMax = height[left];
				}
				if (height[right] > rightMax) {
					rightMax = height[right];
				}
				if (leftMax < rightMax) {
					res += Math.max(0, leftMax - height[left]);
					left++;
				} else {
					res += Math.max(0, rightMax - height[right]);
					right--;
				}
			}
			return res;

		}
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
