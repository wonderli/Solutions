//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
import java.util.*;
public class Solution{
    public boolean isValidSudoku(char[][] board){
        int column[] = new int[9];
        int row[] = new int[9];
        int block[] = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int x = board[i][j] - '0';
                if((column[j] & (1 << x)) != 0) return false;
                if((row[i] & (1 << x)) != 0) return false;
                if((block[i/3 * 3 + j/3] & (1 << x)) != 0) return false;
                column[j] += (1 << x);
                row[i] += (1 << x);
                block[i/3 * 3 + j/3] += (1 << x);
            }
        }
        return true;
    }
        
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
