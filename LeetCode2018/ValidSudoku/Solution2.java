import java.util.*;
public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        //int m = board.length;
        // int n = board[0].length;
        boolean[][] rows = new boolean[10][10];
        boolean[][] cols = new boolean[10][10];
        boolean[][] sections = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int c = Character.getNumericValue(board[i][j]);
                    if (rows[i][c]) return false;
                    if (cols[j][c]) return false;
                    if (sections[i / 3 * 3 + j / 3][c]) return false;
                    rows[i][c] = true;
                    cols[j][c] = true;
                    sections[i / 3 * 3 + j / 3][c] = true;
                }
            }
        }
        return true;
    }
}