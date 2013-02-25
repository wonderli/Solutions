import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
    public static long solve(int target, int base){
        int size = 0;
        int cand = 1;
        while(cand <= target){
            cand *= base;
            size++;
        }
        int S[] = new int[size];
        S[0] = 1;
        for(int i = 1; i < size; i++){
            S[i] = S[i - 1] * base;
        }
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i < size; i++){
            for(int j = S[i]; j <= target; j++){
                dp[j] += dp[j - S[i]];
            }
        }
        return dp[target]%1000000007;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(solve(N, M));
    }
}
