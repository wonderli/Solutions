import java.util.*;
class Solution {
    int m;
    int n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0||matrix[0].length == 0) return new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            pQueue.add(new int[]{i, 0});
            aQueue.add(new int[]{i, n-1});
        }
        for(int j = 0; j < n; j++){
            pQueue.add(new int[]{0, j});
            aQueue.add(new int[]{m-1, j});
        }
        boolean[][] pReachable = bfs(matrix, pQueue);
        boolean[][] aReachable = bfs(matrix, aQueue);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pReachable[i][j] && aReachable[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
        
        
    }
    
    private boolean[][] bfs(int[][] matrix, Queue<int[]> queue){
        boolean[][] reachable = new boolean[m][n];
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            reachable[i][j] = true;
            for(int[] d : directions){
                int x = i + d[0];
                int y = j + d[1];
                if(0 <=x && x < m && 0<= y && y < n && matrix[x][y] >= matrix[i][j] && !reachable[x][y]){
                    queue.add(new int[]{x, y});
                }
            }
        }
        return reachable;
    }
}