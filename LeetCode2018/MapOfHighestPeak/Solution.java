import java.util.*;
class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(isWater[i][j] == 1){
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                }else{
                    result[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            // System.out.println(" i " + i + " j " + j);
            // print(result);
            for(int[] d : directions){
                int x = i + d[0];
                int y = j + d[1];
                if(0 <= x && x < m && 0 <= y && y < n && result[x][y] == -1){
                    result[x][y] = result[i][j] + 1;
                    // System.out.println(" i " + i + " j " + j + " result[i][j] " + result[i][j]);
                    // System.out.println(" x " + x + " y " + y + " result[x][y] " + result[x][y]);
                    queue.add(new int[]{x, y});
                }
            }
        }
        // print(result);
        return result;
    }
    private void print(int[][] matrix){
        System.out.println();
        for(int[] e : matrix){
            System.out.println(Arrays.toString(e));
        }
        System.out.println();
    }
}
