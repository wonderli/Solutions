import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int m;
    int n;
    int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int i = click[0];
        int j = click[1];
        boolean[][] visited = new boolean[m][n];
        bfs(board, i, j, visited);
        return board;
    }

    private void bfs(char[][] board, int i, int j, boolean[][] visited) {
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            char c = board[curr[0]][curr[1]];
            int nearBy = check(board, curr[0], curr[1]);

            board[curr[0]][curr[1]] = nearBy == 0 ? 'B' : (char) (nearBy + '0');
            if (board[curr[0]][curr[1]] == 'B') {
                for (int[] d : directions) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'E' && !visited[x][y]) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }


        }
    }

    private int check(char[][] board, int i, int j) {
        int count = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M') {
                count++;
            }
        }
        return count;
    }
}