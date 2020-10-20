import java.util.*;
public class Solution2{
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = helper(A[0], B, A, n);
        if(rotations != -1 || A[0] == B[0]) return rotations;
        else return helper(B[0], B, A, n);
    }
    private int helper(int x, int[] A, int[] B, int n){
        int rotationsA = 0;
        int rotationsB = 0;
        for(int i = 0; i < n; i++){
            if(A[i] != x && B[i] != x) return -1;

            else if(A[i] != x) rotationsA++;
            else if(B[i] != x) rotationsB++;
        }
        return Math.min(rotationsA, rotationsB);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
