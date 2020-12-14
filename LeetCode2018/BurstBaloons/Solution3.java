import java.util.*;
public class Solution3{
	public int maxCoins(int[] nums) {
		int n = nums.length + 2;
		int[] newNums = new int[n];
		for(int i = 0; i < nums.length; i++){
			newNums[i+1] = nums[i];
		}
		newNums[0] = 1;
		newNums[n-1] = 1;
		int[][] dp = new int[n][n];
		for(int gap = 2; gap < n; gap++){
			for(int left = 0; left < n - gap; left++){
				int right = left + gap;
				for(int i = left + 1; i < right; i++){
					dp[left][right] = Math.max(dp[left][right], newNums[left] * newNums[i] * newNums[right] + dp[left][i] + dp[i][right]);
				}
			}
		}
		return dp[0][n-1];
	}
	public static void main(String args[]){
		Solution3 sol = new Solution3();
	}
}
