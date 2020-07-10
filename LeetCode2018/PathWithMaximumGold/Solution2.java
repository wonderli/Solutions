import java.util.*;
public class Solution2{
    int max = 0;
    int row;
    int col;
    public int getMaximumGold(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                boolean[][] visited = new boolean[row][col];
                helper(i, j, grid, visited, 0);
            }
        }
        return max;
    }
    public void helper(int r, int c, int[][] grid, boolean[][] visited, int curr){
        if(r < 0 || r >= row || c < 0 || c >= col || visited[r][c] || grid[r][c] == 0){
            return;
        }
        visited[r][c] = true;
        int n = grid[r][c];
        curr += n;
        max = Math.max(max, curr);
        helper(r - 1, c, grid, visited, curr);
        helper(r + 1, c, grid, visited, curr);
        helper(r, c - 1, grid, visited, curr);
        helper(r, c + 1, grid, visited, curr);
        visited[r][c] = false;

    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        //int[][] grid = {{0,6,0}, {5, 8, 7}, {0, 9,0}};
        int[][] grid = {{1,0,7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(sol.getMaximumGold(grid));
        //System.out.println(sol.res);
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
