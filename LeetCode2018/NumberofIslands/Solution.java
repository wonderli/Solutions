import java.util.*;
public class Solution{
    int m;
    int n;
    char[][] g;

    public int numIslands(char[][] grid) {
        g = grid;
        int count = 0;
        m = grid.length;
        if( m == 0) return 0;
        n = grid[0].length;
        if( n == 0) return 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(g[i][j] == '1'){
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || g[i][j] != '1') return;
        g[i][j] = '0';
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);

    }
    public void print(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0', '0', '0', '0', '0'}};
        sol.numIslands(grid);
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
