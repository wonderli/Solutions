import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class TicTacToe {

    int size;
    int[] row;
    int[] col;
    int diagonal = 0;
    int antidiagonal = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        row = new int[n];
        col = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(check(row, col, player)){
            return player;
        }
        return 0;
    }
    private boolean check(int r, int c, int player){
        int offset = player == 1 ? 1 : -1;
        int m = size * offset;
        row[r] += offset;
        col[c] += offset;
        if(r == c){
            diagonal += offset;
        }
        if(r + c == size - 1){
            antidiagonal += offset;
        }
        return (row[r] == m || col[c] == m||diagonal == m || antidiagonal == m);
    }
}
