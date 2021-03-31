import java.util.*;
public class Solution{
    public int solve(int a[], int b[], int n){
        int dp[] = new int[n]; 
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            dp[i] = b[i];
        }
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(a[i] > a[j]){
                    dp[i] = Math.max(dp[i], dp[j] + b[i]);
                }
            }
            sum = Math.max(sum, dp[i]);
        }
        return Math.max(sum, dp[0]);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int len = sc.nextInt();
            if(len == 0){
                break;
            }
            int a[] = new int[len];
            for(int i = 0; i < len; i++){
                a[i] = sc.nextInt();
            }
            int b[] = new int[len];
            for(int i = 0; i < len; i++){
                b[i] = sc.nextInt();
            }
            System.out.println(sol.solve(a, b, len));
        }
    }
}
