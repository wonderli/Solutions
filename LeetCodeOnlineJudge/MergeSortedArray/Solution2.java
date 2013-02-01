//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//Note:
//You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
import java.util.*;
public class Solution2{
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(k >= 0){
            if(i >= 0 && j >= 0 && A[i] > B[j]){
                A[k] = A[i];
                k--;
                i--;
            }else if(i >= 0 && j >= 0 && A[i] <= B[j]){
                A[k] = B[j];
                k--;
                j--;
            }else if(i < 0 && j >= 0){
                A[k] = B[j];
                k--;
                j--;
            }else if(j < 0 && i >= 0){
                A[k] = A[i];
                k--;
                i--;
            }
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int A[] = {1, 2, 4, 5, 6, 0, 0, 0};
        int B[] = {3};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        sol.merge(A, 5, B, 1);
        System.out.println(Arrays.toString(A));
    }

}
