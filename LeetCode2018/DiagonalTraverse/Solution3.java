import java.util.*;
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        int[] result = new int[m*n];
        int i = 0;
        int j = 0;
        result[0] = matrix[0][0];
        int k = 1;
        while( k < m * n){
            while(i -1 >= 0 && j + 1 < n){
                i--;
                j++;
                result[k] = matrix[i][j];
                k++;
            }
            if(j < n - 1){
                j++;
                result[k] = matrix[i][j];
                k++;
            }else if(i < m - 1){
                i++;
                result[k] = matrix[i][j];
                k++;
            }
            while(i + 1 < m && j -1 >= 0){
                j--;
                i++;
                result[k] = matrix[i][j];
                k++;
            }
            if(i < m - 1){
                i++;
                result[k] = matrix[i][j];
                k++;
            }else if(j < n -1){
                j++;
                result[k] = matrix[i][j];
                k++;
            }
        }
        return result;
        
    }
}