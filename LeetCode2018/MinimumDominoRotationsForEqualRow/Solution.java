import java.util.*;
public class Solution{
    public int minDominoRotations(int[] A, int[] B) {
        int[] a = new int[7];
        int[] b = new int[7];
        for(int i = 0; i < A.length;i++){
            a[A[i]]++;
            b[B[i]]++;
        }
        List<Integer> candidates = new ArrayList<>();
        for(int i = 1; i < a.length; i++){
            if(a[i] + b[i] >= A.length){
                candidates.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : candidates){
            int h = helper(i, A, B);
            if(h == -1){
                continue;
            }
            min = Math.min(min, helper(i, A, B));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int helper(int num, int[] A, int[] B){
        int numA = 0;
        int numB = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == num){
                numA++;
            }
            if(B[i] == num){
                numB++;
            }
        }
        int a = flip(num, A, B);
        int b = flip(num, B, A);
        if(a == -1) return b;
        if(b == -1) return a;
        return Math.min(a, b);
    }
    private int flip(int num, int[] A, int[] B){
        int ret = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == num){
                continue;
            }else if(A[i] != num && B[i] == num){
                ret++;
            }else if(A[i] != num && B[i] != num){
                return -1;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] A = {1,2,3,4,6};
        int[] B = {6,6,6,6,5};
        System.out.println(sol.minDominoRotations(A, B));
    }
}
