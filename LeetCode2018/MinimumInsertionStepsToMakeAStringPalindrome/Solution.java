import java.util.*;
public class Solution {
	public int minInsertions(String s) {
		int n = s.length();
		int[][] dp = new int[n+1][n+1];
		char[] cs = s.toCharArray();
		for(int j = 1; j <= n;j++){
			for(int i = j; i >= 1; i--){
				if(i == j){
					dp[i][j] = 0;
				}else if(j - i == 1){
					dp[i][j] = cs[i-1] == cs[j-1] ? 0 : 1;
				}else {
					if(cs[i-1] == cs[j-1]){
						dp[i][j] = dp[i+1][j-1];
					}else{
						dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
					}
				}
			}
		}
		return dp[1][n];
	}
}
