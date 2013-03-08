//Median of Two Sorted Arrays 
//
//There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
import java.util.*;
public class Solution2{
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if(((m + n) & 1) == 1){
            return kth(A, m, B, n, (m + n + 1)/2);
        }else{
            return (kth(A, m, B, n, (m + n)/2) + kth(A, m, B, n, (m+n)/2 + 1))/2;
        }
    }
    public double kth(int A[], int m, int B[], int n, int k){
        if(m == 0) return B[k-1];
        if(n == 0) return A[k-1];
        int i = (int)((double)(m)/(m + n) * (k-1));
        int j = k - 1 - i;
        int ai = (i == m) ? Integer.MAX_VALUE : A[i];
        int bj = (j == n) ? Integer.MAX_VALUE : B[j];
        int ai_1 = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
        int bj_1 = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
        if(ai >= bj_1 && ai <= bj) return ai;
        if(bj >= ai_1 && bj <= ai) return bj;
        if(ai < bj_1){
            int nA[] = Arrays.copyOfRange(A, i + 1, m);
            return kth(nA, nA.length, B, n, k - i - 1);
        }else{
            int nB[] = Arrays.copyOfRange(B, j + 1, n);
            return kth(A, m, nB, nB.length, k - j - 1);
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        //int A[] = {1, 12, 15, 26, 38};
        //int B[] = {2, 13, 17, 30, 45};
        //int A[] = {1,1};
        //int B[] = {1,1};
        int A[] = {2, 3, 4};
        int B[] = {1};
        System.out.println(sol.findMedianSortedArrays(A, B));
    }
}
