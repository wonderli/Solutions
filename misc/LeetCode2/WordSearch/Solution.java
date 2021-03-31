import java.util.*;
public class Solution{
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0|| board[0].length == 0) return false;
        if(word == null || word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean mark[][] = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(search(i, j, 0, m, n, mark, board, word)) return true;
            }
        }
        return false;
    }
    public boolean search(int x, int y, int k, int m, int n, boolean mark[][], char[][] board, String word){
        if(k == word.length()) return true;
        if(x < 0 || x >= m || y < 0 || y >= n) return false; 
        if(board[x][y] != word.charAt(k) || mark[x][y]) return false;
        mark[x][y] = true;
        if(search(x - 1, y, k + 1, m, n, mark, board, word)) return true;
        if(search(x + 1, y, k + 1, m, n, mark, board, word)) return true;
        if(search(x, y - 1, k + 1, m, n, mark, board, word)) return true;
        if(search(x, y + 1, k + 1, m, n, mark, board, word)) return true;
        mark[x][y] = false;
        return false;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
