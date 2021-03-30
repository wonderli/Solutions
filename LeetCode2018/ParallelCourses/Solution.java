import java.util.*;
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        for(int[] r : relations){
            int a = r[0];
            int b = r[1];
            indegrees.put(b, indegrees.getOrDefault(b, 0)+1);
            graph.computeIfAbsent(a, (k -> new ArrayList<>())).add(b);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(indegrees.getOrDefault(i, 0) == 0){
                queue.add(i);
                count++;
            }
        }
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                List<Integer> list = graph.getOrDefault(curr, new ArrayList<>());
                for(int e : list){
                    indegrees.put(e, indegrees.get(e) - 1);
                    if(indegrees.get(e) == 0){
                        queue.add(e);
                        count++;
                    }
                }
            }
            step++;
            
            
        }
        
        return count== n ? step : -1;
    }
}
