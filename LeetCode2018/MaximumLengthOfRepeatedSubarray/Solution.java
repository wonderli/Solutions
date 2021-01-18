import java.util.*;
public class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = m-1; i>= 0;  i--){
            for(int j = n-1; j>=0;j--){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }
                    if(dp[i][j] > max){
                        max = dp[i][j];
                    }
            }
        }
        return max;
    }
}
