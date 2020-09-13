class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !hasZero(matrix, i, j)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j, -1);
                }

            }
        }
        return matrix;
    }

    public boolean hasZero(int[][] matrix, int i, int j) {
        if (i > 0 && matrix[i - 1][j] == 0) {
            return true;
        }
        if (j > 0 && matrix[i][j - 1] == 0) {
            return true;
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] == 0) {
            return true;
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] == 0) {
            return true;
        }
        return false;
    }

    public void dfs(int[][] matrix, int i, int j, int val) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= val) return;
        if (val > 0) {
            matrix[i][j] = val;
        }
        dfs(matrix, i - 1, j, matrix[i][j] + 1);
        dfs(matrix, i + 1, j, matrix[i][j] + 1);
        dfs(matrix, i, j - 1, matrix[i][j] + 1);
        dfs(matrix, i, j + 1, matrix[i][j] + 1);
    }
}