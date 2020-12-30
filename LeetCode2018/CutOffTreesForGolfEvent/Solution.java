import java.util.*;
class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n;j ++){
                if(forest.get(i).get(j) > 1){
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }
        int[] start = new int[2];
        int sum = 0;
        while(!pq.isEmpty()){
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree);
            if(step < 0) return -1;
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum; 
    }
    private int minStep(List<List<Integer>> forest, int[] start, int[] tree){
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                if(curr[0] == tree[0] && curr[1] == tree[1]) return step;
                for(int[] d : directions){
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if(x <0 || x >= m || y < 0 || y >= n || forest.get(x).get(y) == 0 || visited[x][y]) continue;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }
}