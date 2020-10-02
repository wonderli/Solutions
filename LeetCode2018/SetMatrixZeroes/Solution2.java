import java.util.*;
public class Solution2{
    public void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(j == 0) firstCol = true;
                    if(i == 0) firstRow = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[0][j] == 0|| matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0; 
            }
        }
        if(firstCol){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
