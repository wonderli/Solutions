import java.util.*;
public class Solution{
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[] neighbors = {-1, 0, 1};
        int[][] copy = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                copy[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int living = 0;
                for(int m = 0; m < 3; m++){
                    for(int n = 0; n < 3; n++){
                        if(!(neighbors[m] == 0 && neighbors[n] == 0)){
                            int r = (i + neighbors[m]);
                            int c = (j + neighbors[n]);
                            if((r < row && r>= 0) && (c < col && c >= 0) && (copy[r][c] == 1)){
                                living++;
                            }
                        }
                    }
                }
                if((copy[i][j] == 1) && (living < 2 || living > 3)){
                    board[i][j] = 0;
                }
                if(copy[i][j] == 0 && living == 3){
                    board[i][j] = 1;
                }

            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
