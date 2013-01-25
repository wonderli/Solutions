//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
public class Solution2{
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean r = false;
        boolean c = false;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                c = true;
                break;
            }
        }
        for(int i= 0; i < n; i++){
            if(matrix[0][i] == 0){
                r = true;
                break;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(r){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(c){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int A[][] = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        sol.setZeroes(A);
    }
}
