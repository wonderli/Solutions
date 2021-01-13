class Solution4 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < (n+1)/2; i++){
            //for(int diff = 0; diff < n - 1 - 2*i; diff++){
              //  int j = i + diff;
            for(int j = 0; j < n /2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1 - j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}