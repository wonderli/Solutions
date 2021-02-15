import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while(!queue.isEmpty()){
                    int curr = queue.poll();
                    for(int e : graph[curr]){
                        if(color[e] == 0){
                            queue.add(e);
                            color[e] = color[curr] == 1 ? 2 : 1;
                        }else if(color[e] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}