import java.util.*;
public class Solution{
    public void merge(int A[], int m, int B[], int n) {
        if(n == 0) return ;
        int len = A.length;
        m = m - 1;
        n = n - 1;
        for(int i = len - 1; i >= 0; i--){
            int a = m >= 0 ? A[m] : Integer.MIN_VALUE;
            int b = n >= 0 ? B[n] : Integer.MIN_VALUE;
            if(a > b) {
                A[i] = a;
                m--;
            }else {
                A[i] = b;
                n--;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {1, 3, 5, 7, 0, 0, 0, 0};
        int B[] = {2, 4, 6, 8};
        sol.merge(A, 4, B, 4);
        System.out.println(Arrays.toString(A));
    }
}
