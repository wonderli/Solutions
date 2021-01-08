class Solution3 {
       int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m;
    int n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return matrix;
        n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !hasZero(matrix, i, j)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    dfs(matrix, i, j, -1);
                }
            }
        }
        return matrix;
    }

    private void dfs(int[][] matrix, int i, int j, int v) {
        if(i < 0 || i >= m || j <0 || j>= n || matrix[i][j] <= v) return;
        if(v > 0){
            matrix[i][j] = v;
        }
        for(int[] d : directions){
            int x = i + d[0];
            int y = j + d[1];
            dfs(matrix, x, y, matrix[i][j] + 1);
        }
    }

    private boolean hasZero(int[][] matrix, int i, int j) {
        for(int[] d : directions){
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < m  && y >=0 && y < n){
                if(matrix[x][y] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}