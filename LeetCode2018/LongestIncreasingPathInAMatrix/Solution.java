class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 ||matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        int[][] cache = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0;j < col; j++){
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        }
        return res;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        
        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if(0 <= x && x < matrix.length && 0<=y && y < matrix[0].length && matrix[x][y] > matrix[i][j]){
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        cache[i][j]++;
        return cache[i][j];
    }
}