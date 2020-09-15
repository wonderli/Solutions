import java.util.*;
public class Solution{
    int[][] direction = {{-1, 1},
            {1, -1}};
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ret = new int[m * n];
        int index = 0;
        int r = 0;
        int c = 0;
        int i = 0;
        int d = 0;
        while( i < ret.length){
            while(r >= 0 && r < m && c >= 0 && c < n){
                ret[i] = matrix[r][c];
                i++;
                r += direction[d][0];
                c += direction[d][1];
            }
            d = (d + 1)%2;
            if(r == m){
                r--;
                c += 2;
            }
            if(c == n){
                r += 2;
                c--;
            }
            if(r < 0){
                r = 0;
            }
            if(c < 0){
                c = 0;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sol.findDiagonalOrder(matrix);
    }
}
