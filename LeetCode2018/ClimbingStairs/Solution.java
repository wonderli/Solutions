import java.util.*;
public class Solution{
	public int climbStairs(int n) {
		if(n == 0 || n == 1) return 1;
		if(n == 2) return 2;
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i < n+1;i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		System.out.println(sol.climbStairs(3));

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
