import java.util.*;
public class Solution{
    int ret = 0;
    public int totalNQueens(int n) {
        if(n == 0) return 0;
        int[] list = new int[n];
        helper(list, 0);
        return ret;
    }
    public void helper(int[] list, int col){
        if(col == list.length){
            ret++;
            return;
        }
        for(int r = 0; r < list.length; r++){
            if(check(r, col, list)){
                list[col] = r;
                helper(list, col+1);
            }
        }
    }
    public boolean check(int row, int col, int[] list){
        for(int c = 0; c < col; c++){
            int r = list[c];
            if(r == row) return false;
            if(r + c == row + col || r - c == row - col) return false;
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.totalNQueens(4));
    }
}