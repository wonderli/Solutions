import java.util.*;
public class Solution{
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0) return new int[0];
		int len = digits.length;
		int result[] = new int[len +1];
		int j = len;
		int carry = 1;
		for(int i = len - 1; i >= 0; i--, j--){
			if(digits[i] + carry > 9){
				carry = 1;
				result[j] = 0;
			}else{
				result[j] = digits[i] + carry;
				carry = 0;
			}
		}
		if(carry == 1){
			result[j] = 1;
		}else{
			result = Arrays.copyOfRange(result, 1, result.length); 
		}
		return result;
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		//int[] digits = {1, 2, 3};
		//int[] digits = {1, 2, 9};
		//int[] digits = {9, 9, 9};
		int[] digits = {9};
		System.out.println(Arrays.toString(sol.plusOne(digits)));
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
