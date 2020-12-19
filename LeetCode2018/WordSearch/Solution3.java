import java.util.*;
class Solution3 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        if(board.length == 0||board[0].length == 0 || word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j, visited, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int index){
        if(index == word.length() - 1){
            return !visited[i][j] && board[i][j] == word.charAt(index);
        }
        if(!visited[i][j] && board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            for(int[] d : directions){
                int x = i + d[0];
                int y = j + d[1];
                if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && dfs(board, x, y, visited, word, index+1)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
