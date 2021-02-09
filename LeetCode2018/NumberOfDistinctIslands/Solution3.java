import java.util.*;
class Solution3 {
    private int[][] grid;
    private boolean[][] visited;
    private StringBuilder sb;
    int m;
    int n;
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        visited = new boolean[m][n];
        Set<String> islands = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sb = new StringBuilder();
                dfs(i, j, '0');
                if(sb.length() == 0){
                    continue;
                }
                islands.add(sb.toString());
            }
        }
        return islands.size();
    }
    private void dfs(int i, int j, char c){
        if(i < 0 || i >= m || j < 0 || j>=n ||grid[i][j] == 0||visited[i][j]){
            return;
        }
        visited[i][j] = true;
        sb.append(c);
        dfs(i+1, j, 'D');
        dfs(i-1, j, 'U');
        dfs(i, j+1, 'R');
        dfs(i, j-1, 'L');
        sb.append('0');
    }
}