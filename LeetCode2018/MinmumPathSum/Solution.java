import java.util.*;
public class Solution{
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < col; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < row;i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];

    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
