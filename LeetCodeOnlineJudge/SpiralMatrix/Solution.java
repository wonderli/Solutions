//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
import java.util.*;
public class Solution{
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        //ArrayList<Integer> ret = new ArrayList<Integer>();
        ArrayList<Integer> ret = helper(matrix, 0, 0, row, col);
        return ret;
    }
    ArrayList<Integer> helper(int[][] matrix, int x, int y, int m, int n){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(m <= 0 || n <= 0) return ret;
        for(int i = y; i < y+n; i++){
            ret.add(matrix[x][i]);
        }
        for(int i = x + 1; i < x + m - 1; i++){
            ret.add(matrix[i][y + n - 1]);
        }
        if(m > 1){
            for(int i = y + n - 1; i >= y; i--){
                ret.add(matrix[x + m - 1][i]);
            }
        }
        if(n > 1){
            for(int i = x + m - 2; i > x; i--){
                ret.add(matrix[i][y]);
            }
        }
        ret.addAll(helper(matrix, x + 1, y + 1, m - 2, n - 2));
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int matrix[][] = {{1,2,3},{4, 5, 6},{7, 8, 9}};
        System.out.println(sol.spiralOrder(matrix));
    }
}
