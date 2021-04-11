import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    int m;
    int n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int solve(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        if(m == 0||n == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[2] - b[2]));
 
        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;
        pq.add(new int[]{0, 0, 0});
        int dist = Integer.MAX_VALUE;
        while(!visited[m-1][n-1]){
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            dist = curr[2];
            if(visited[i][j]) continue;
            
            visited[i][j] = true;
            if(i == m-1 && j == n-1){
                return dist;
            }
            
            for(int[] d :directions){
                int x = i + d[0];
                int y = j + d[1];
                if(0 <= x && x < m && 0 <= y && y < n){
                    int e = distance[i][j] + Math.abs(matrix[i][j] - matrix[x][y]);
                    if(!visited[x][y] && e < distance[x][y]){
                        pq.add(new int[]{x, y, e});
                        distance[x][y] = e;
                    }
                    
                }
            }
        }
        return dist;

    }
}