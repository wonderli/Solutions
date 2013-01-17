//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//Note:
//You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
import java.util.*;
public class Solution{
    public void merge(int A[], int m, int B[], int n) {
        if(m == 0){
            for(int i = 0; i < B.length; i++){
                A[i] = B[i];
            }
        }
        if(n == 0) return;
        int i = A.length - 1;
        int j = m - 1;
        int k = n - 1;
        while(i >= 0 && j >= 0 && k >= 0){
            if(A[j] >= B[k]){
                A[i] = A[j];
                j--;
            }else{
                A[i] = B[k];
                k--;
            }
            i--;
        }

        if(j >= 0 && k < 0){
            while(i >= 0 && j >= 0){
                A[i] = A[j];
                j--;
                i--;
            }
        }
        if(k >= 0 && j < 0){
            while(i >=0 && k >= 0){
                A[i] = B[k];
                k--;
                i--;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {4, 5, 6, 0, 0, 0};
        int B[] = {1, 2, 3};
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        sol.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

}
