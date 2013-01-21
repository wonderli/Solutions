//Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//For example,
//There exist two distinct solutions to the 4-queens puzzle:
import java.util.*;
public class Solution{
    public ArrayList<String[]> solveNQueens(int n) {
        int list[] = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = 0;
        }
        ArrayList<String[]> ret = new ArrayList<String[]>();
        place(list, 0, ret);
        return ret;
    }
    public String[] convert(int[] A){
        int len = A.length;
        String ret[] = new String[len];
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < len; j++){
                if(j == A[i]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            ret[i] = sb.toString();
        }
        return ret;
    }
    public boolean check(int row, int col, int list[]){
        for(int c = 0; c < col; c++){
            int r = list[c];
            if(r == row){
                return false;
            }
            if(c == col){
                return false;
            }
            if(r-c == row - col || r + c == row + col){
                return false;
            }
        }
        return true;
    }
    public void place(int list[], int col, ArrayList<String[]> ret){
        if(col == list.length){
            ret.add(convert(list));
            return;
        }
        for(int r = 0; r < list.length; r++){
            if(check(r, col, list)){
                list[col] = r;
                place(list, col + 1, ret);
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int n = 8;
        ArrayList<String[] > ret = sol.solveNQueens(n);
        for(String[] e : ret){
            System.out.println(Arrays.toString(e));
        }
    }
}
