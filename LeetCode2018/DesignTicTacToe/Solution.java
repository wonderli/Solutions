import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TicTacToe {

    int PLAYER1 = -1;
    int PLAYER2 = 1;
    int[] rows;
    int[] cols;
    int[] diag;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = new int[2];
        this.n = n;
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
        rows[row] += player == 1 ? -1 : 1;
        if(rows[row] == -n){
            return 1;
        }else if(rows[row] == n){
            return 2;
        }
        cols[col] += player == 1 ? -1 : 1;
        if(cols[col] == -n){
            return 1;
        }else if(cols[col] == n){
            return 2;
        }
        if(row == col){
            diag[0] += player == 1 ? -1 : 1 ;
            if(diag[0] == -n){
                return 1;
            }else if(diag[0] == n){
                return 2;
            }
        }
        if(row + col == n-1){
            diag[1] += player == 1 ? -1 : 1;
            if(diag[1] == -n){
                return 1;
            }else if(diag[1] == n){
                return 2;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
