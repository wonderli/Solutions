import java.util.*;
public class Solution{
	public int mySqrt(int x) {
		if(x == 0) return 0;
		int left = 1;
		int right = x;
		int result = 0;
		while(left <= right){
			int mid = left + (right - left) /2;
			if(mid <= x/mid){
				left = mid + 1;
				result = mid;
			}else{
				right = mid - 1;
			}
		}
		return result; 
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		System.out.println(sol.mySqrt(8));
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
