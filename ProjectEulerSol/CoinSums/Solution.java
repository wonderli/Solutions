public class Solution{
    public static void coinSum(int sum){
        int A[] = {1, 2, 5, 10, 20, 50, 100, 200};
        int m = A.length;
        int n = sum;
        int dp[][] = new int[n+1][m];
        for(int i = 0; i < m; i++){
            dp[0][i] = 1;
        }
        int x = 0;
        int y = 0;
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < m; j++){
                x = (i - A[j] >= 0)? dp[i - A[j]][j] : 0;
                y = (j >= 1)? dp[i][j-1]:0;
                dp[i][j] = x + y;
            }
        }
        System.out.println(dp[sum][m-1]);
    }
    public static void main(String args[]){
        coinSum(200);
    }
}
