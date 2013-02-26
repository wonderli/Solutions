public class Solution{
    int m, n;
    char board[][];
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        this.board = board;
        m = board.length;
        n = board[0].length;

        for(int j = 0; j < n; j++){
            dfs(0, j);
            dfs(m - 1, j);
        }
        for(int i = 0; i < m; i++){
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'D') board[i][j] = 'O';
            }
        }

    }
    public void dfs(int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
        board[x][y] = 'D';
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
