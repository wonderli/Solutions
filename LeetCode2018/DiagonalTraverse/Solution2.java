import java.util.*;
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int[] result = new int[m * n];
        
        for(int k = 0; k < m * n; k++){
            result[k] = matrix[i][j];
            // Even
            if((i + j) % 2 == 0){
                if(i - 1 >= 0 && j + 1 < n){
                    j++;
                    i--;
                }else if(i - 1 < 0 && j + 1 < n){
                    j++;
                }else if(i + 1 < m && j + 1 > n - 1){
                    i++;
                }
            }else{
                if(i + 1 < m && j - 1 >= 0){
                    i++;
                    j--;
                }else if(i +1 < m && j - 1 < 0){
                    i++;
                }else if(i + 1 > m - 1 && j + 1 < n){
                    j++;
                }
            }
        }
        return result;
    }
}