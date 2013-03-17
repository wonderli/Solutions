import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int helper(int A[], int n, int k, int M){
        Arrays.sort(A);
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(A, 0, 0, n, k, M, max, 0);
        return max[0];
    }
    public static void helper(int A[], int index, int size, int n, int k, int M, int max[], int sum){
        if(size == k){
            if(sum < M && max[0] < sum){
                max[0] = sum;
            }
        }
        for(int i = index; i < n; i++){
            helper(A, i + 1, size + 1, n, k, M, max, sum + A[i]);
        }
    }
    public static int helper(int n, int m){
        if(n < 1||m < 1) return 0;
        if(n == 1||m == 1) return 1;
        if(n < m) return helper(n, n)%1000000007;
        if(n == m) return (helper(n, m-1) + 1)%1000000007;
        if(n > m) return (helper(n, m-1) + helper(n-m, m))%1000000007;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int M = sc.nextInt();
        int i = 0;
        int A[] = new int[n];
        while(i < n){
            A[i] = sc.nextInt();
            i++;
        }
        int Z = helper(A, n, k, M);
        System.out.println(Z);
        System.out.println(helper(Z, Z));
    }
}
