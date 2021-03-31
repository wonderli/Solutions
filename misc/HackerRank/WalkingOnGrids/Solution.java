import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int solve(int N){
        if(N == 1) return 1;
        int dp[][] = new int[N+1][N+1];
        dp[1][1] = 1;
        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%10007;
            }
        }
        return (dp[N][N] * 2)%10007;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solve(N));
    }
}
