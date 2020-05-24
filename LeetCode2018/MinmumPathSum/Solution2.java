import java.util.*;
public class Solution2{
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j>=0; j--){
                if(i == row - 1 && j != col -1){
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                }else if(j == col - 1 && i != row - 1){
                    grid[i][j] = grid[i][j] + grid[i+1][j];
                }else if(i != row - 1 && j != col -1){
                    grid[i][j] = grid[i][j] + Math.min(grid[i+1][j] , grid[i][j+1]);
                }
            }
        }
        return grid[0][0];

    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
