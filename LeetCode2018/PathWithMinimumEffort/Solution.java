import java.util.*;
public class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        queue.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[1] == m-1 && curr[2] == n-1){
                return curr[0];
            }
            visited[curr[1]][curr[2]] = true;
            for(int[] d : directions){
                int x= curr[1] + d[0];
                int y = curr[2] + d[1];
                if(0 <= x && x < m && 0 <= y && y < n && !visited[x][y]){
                    int maxDiff = Math.max(curr[0], Math.abs(heights[x][y] - heights[curr[1]][curr[2]]));
                    queue.add(new int[]{maxDiff, x, y});
                }
            }
        }
        return -1;    
    }
    
}
