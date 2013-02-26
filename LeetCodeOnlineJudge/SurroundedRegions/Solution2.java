import java.util.*;
public class Solution2{
    int m, n;
    char board[][];
    Queue<Integer> q = new LinkedList<Integer>();
    public void fill(int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
        q.offer(x * m + y);
        board[x][y] = 'D';
    }
    public void bfs(int x, int y){
        fill(x,y);
        while(!q.isEmpty()){
            int curr = q.poll();
            int i = curr/n;
            int j = curr%n;
            fill(i-1, j);
            fill(i+1, j);
            fill(i, j - 1);
            fill(i, j + 1);
        }
    }
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        this.board = board;
        m = board.length;
        n = board[0].length;
        for(int j = 0; j < n; j++){
            bfs(0, j);
            bfs(m-1, j);
        }
        for(int i = 1; i < m - 1; i++){
            bfs(i, 0);
            bfs(i, n-1);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'D') board[i][j] = 'O';
            }
        }
    }
    public void print(){
        System.out.println();
           for(char e[] : board){
               System.out.println(Arrays.toString(e));
           }
        System.out.println();
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
        Solution2 sol = new Solution2();
        char board[][] = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}};
        for(char e[] : board){
            System.out.println(Arrays.toString(e));
        }
        sol.solve(board);
    }
}
