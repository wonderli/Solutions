import java.util.*;

public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowSet = new boolean[10][10];
        boolean[][] colSet = new boolean[10][10];
        boolean[][] sectionSet = new boolean[10][10];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char v = board[r][c];
                if (v != '.') {
                    int value = v - '0';
                    rowSet[r][value] = true;
                    colSet[c][value] = true;
                    int index = (r / 3) * 3 + (c / 3);
                    sectionSet[index][value] = true;
                }
            }
        }
        helper(board, rowSet, colSet, sectionSet, 0, 0);
    }

    public boolean helper(char[][] board, boolean[][] rowSet, boolean[][] colSet, boolean[][] sectionSet, int x, int y) {
        if (x == 8 && y == 9) {
            return true;
        } else if (y == 9) {
            y = 0;
            x +=1;
        }
        int index = (x / 3) * 3 + (y / 3);
        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (!rowSet[x][i] && !colSet[y][i] && !sectionSet[index][i]) {
                    rowSet[x][i] = true;
                    colSet[y][i] = true;
                    sectionSet[index][i] = true;
                    board[x][y] = (char) (i + '0');
                    if (helper(board, rowSet, colSet, sectionSet, x, y + 1)) {
                        return true;
                    }

                    rowSet[x][i] = false;
                    colSet[y][i] = false;
                    sectionSet[index][i] = false;
                    board[x][y] = '.';
                }
            }
        } else {
            return helper(board, rowSet, colSet, sectionSet, x, y + 1);
        }
        return false;

    }

    public static void main(String args[]) {
        Solution sol = new Solution();
    }
}
