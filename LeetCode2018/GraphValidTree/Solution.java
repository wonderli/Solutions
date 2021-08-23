import java.util.*;
class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        Set<Integer> visited = new HashSet<>();
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            graph[a][b] = true;
            graph[b][a] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while(!queue.isEmpty()){
            int curr =queue.poll();
            if(visited.contains(curr)) return false;
            for(int i = 0; i < n; i++){
                if(graph[curr][i] == true){
                    queue.add(i);
                    graph[i][curr] = false;
                }
            }
            visited.add(curr);
        }
        return visited.size() == n;
    }
}
