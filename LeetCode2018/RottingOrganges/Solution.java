import java.util.*;
class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] ==  1){
                    fresh++;
                }
            }
        }
        int count = -1;
        if(fresh == 0) return 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                for(int[] d : directions){
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if(0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1){
                        fresh--;
                        queue.add(new int[]{x, y});
                        grid[x][y] =2;
                    }
                }
            }
            count++;
        }
        return fresh == 0? count : -1;
    }
}
