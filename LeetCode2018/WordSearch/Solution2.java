import java.util.*;
public class Solution2{
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j <col; j++){
                boolean[][] visited = new boolean[row][col];
                if(helper(i, j, board, visited, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(int i, int j, char[][] board, boolean[][] visited, int index, String word){
        if(index ==word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length||visited[i][j] || (word.charAt(index) != board[i][j])){
            return false;
        }
        visited[i][j] = true;
        if(helper(i - 1, j, board, visited, index + 1, word)){
            return true;
        }
        if(helper(i + 1, j, board, visited, index + 1, word)){
            return true;
        }

        if(helper(i, j - 1, board, visited, index + 1, word)){
            return true;
        }
        if(helper(i, j + 1, board, visited, index + 1, word)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
