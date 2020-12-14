import java.util.*;
public class Solution2{
	public int maxCoins(int[] nums) {
		int n = nums.length+2;
		int[][] memo = new int[n][n];
		int[] newNums = new int[n];
		for(int i = 0; i < nums.length; i++){
			newNums[i+1] = nums[i];
		}
		newNums[0] = 1;
		newNums[n-1] = 1;

		return burst(memo, newNums, 0, n-1);
	}

	private int burst(int[][] memo, int[] nums, int left, int right){
		if(left+1==right) return 0;
		if(memo[left][right] > 0){
			return memo[left][right];
		}
		int result = 0;
		for(int i = left+1; i < right; i++){
			result = Math.max(result, nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
		}
		memo[left][right] = result;
		return result;
	}

	public static void main(String args[]){
		Solution2 sol = new Solution2();
	}
}
