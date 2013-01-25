//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
public class Solution{
     public void setZeroes(int[][] matrix) {
         if(matrix.length == 0 || matrix[0].length == 0) return;
         int m = matrix.length;
         int n = matrix[0].length;
         boolean row[] = new boolean[m];
         boolean col[] = new boolean[n];
         for(int i = 0; i < m; i++){
             for(int j = 0; j < n; j++){
                 if(matrix[i][j] == 0){
                     row[i] = true;
                     col[j] = true;
                 }
             }
         }
         for(int i = 0; i < m; i++){
             for(int j = 0; j < n; j++){
                 if(row[i] == true || col[j] == true){
                     matrix[i][j] = 0;
                 }
             }
         }
         
     }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
