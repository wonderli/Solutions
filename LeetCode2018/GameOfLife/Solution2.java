class Solution2 {
    
    int D2L = -1;
    int L2D = -2;
    int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        for(int i = 0; i < m ;i++){
            for(int j = 0; j<n; j++){
                checkAndUpdate(board, i, j);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != 0 && board[i][j] != 1){
                    update(board, i, j);
                }
            }
        }
    }
    private void checkAndUpdate(int[][] board, int i, int j){
        int countLive = 0;
        int m = board.length;
        int n = board[0].length;
        for(int[] d : direction){
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < m && y >= 0 && y < n){
                if(board[x][y] == 1 || board[x][y] == L2D){
                    countLive++;
                }
            }
        }
        if(board[i][j] == 1){
            if(countLive < 2){
                board[i][j] = L2D;
            }else if(countLive > 3){
                board[i][j] = L2D;
            }
        }else {
            if(countLive == 3){
                board[i][j] = D2L;
            }
        }
    }
    private void update(int[][] board, int i, int j){
        if(board[i][j] == D2L){
            board[i][j] = 1;
        }else if(board[i][j] == L2D){
            board[i][j] = 0;
        }
    }
}