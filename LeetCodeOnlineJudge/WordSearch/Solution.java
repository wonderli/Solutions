// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more n once.
public class Solution{
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        if(word.length() == 0) return true;
        char c = word.charAt(0);
        int m = board.length;
        int n = board[0].length;
        boolean mark[][] = new boolean[m][n];
        char[] w = word.toCharArray();
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(check(board, w, mark, m, n, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean check(char[][] board, char[] w, boolean mark[][], int m, int n, int x, int y, int p){
        if(p == w.length) return true;
        if(x < 0 || y < 0|| x >= m || y >= n) return false;
        if(board[x][y] != w[p] || mark[x][y]) return false;
        mark[x][y] = true;
        if(check(board, w, mark, m, n, x+1, y, p+1)) return true;
        if(check(board, w, mark, m, n, x-1, y, p+1)) return true;
        if(check(board, w, mark, m, n, x, y+1, p+1)) return true;
        if(check(board, w, mark, m, n, x, y-1, p+1)) return true;
        mark[x][y] = false;
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
