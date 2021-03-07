import java.util.*;
class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m;
    int n;
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        Set<String> result = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    String s = bfs(grid, i, j);
                    result.add(s);
                }
            }
        }
        return result.size();
    }
    
    private String bfs(int[][] grid, int i, int j){
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0, 0});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int p = curr[0];
            int q = curr[1];
            grid[p][q] = 0;            
            int d1 = curr[2];
            int d2 = curr[3];
            if(d1 == 0 && d2 == 0){
                sb.append("O");
            }else if(d1 == 0 && d2 == 1){
                sb.append("R");
            }else if(d1 == 0 && d2 == -1){
                sb.append("L");
            }else if(d1 == -1 && d2 == 0){
                sb.append("U");
            }else if(d1 == 1 && d2 == 0){
                sb.append("D");
            }
            for(int[] d : directions){
                int x = p + d[0];
                int y = q + d[1];
                if(0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1){
                    grid[x][y] = 0;
                    queue.add(new int[]{x, y, d[0], d[1]});
                }else{
                    sb.append(",");
                }
                
            }
            sb.append(",");
        }
        // System.out.println(sb);
        return sb.toString();
    }
    
}