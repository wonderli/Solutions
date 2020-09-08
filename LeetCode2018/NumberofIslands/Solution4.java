import java.util.*;
public class Solution4{
    int[][] dirs = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid, int r, int c){
        grid[r][c] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int row = grid.length;
        int col = grid[0].length;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d : dirs){
                int r1 = curr[0] + d[0];
                int c1 = curr[1] + d[1];
                if(r1 < 0 || r1 >= row || c1 < 0 || c1 >= col || grid[r1][c1] == '0'){
                    continue;
                }
                grid[r1][c1] = '0';
                q.add(new int[]{r1, c1});
            }
        }
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
