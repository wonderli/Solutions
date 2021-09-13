import java.util.*;
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            int c = e[2];
            graph.computeIfAbsent(a, (k -> new HashMap<>())).put(b, c);
            graph.computeIfAbsent(b, (k -> new HashMap<>())).put(a, c);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        pq.add(new int[]{0, maxMoves});
        int result = 0;
        
        Set<Integer> visited = new HashSet<>();        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int left = curr[1];
            
            if(visited.contains(node)) continue;
            visited.add(node);
            result++;
            
            if(!graph.containsKey(node)) continue;

            for(int nei : graph.get(node).keySet()){
                int w = graph.get(node).get(nei);
                if(!visited.contains(nei) && left >=  w  + 1){
                    pq.add(new int[]{nei, left - w - 1});
                }
                int cost = Math.min(left, w);
                graph.get(nei).put(node, w - cost);
                result += cost;
            }    
        }
        return result;             

    }
    private void print(List<int[]> list){
        System.out.println("====");
        for(int[] e : list){
            System.out.println(Arrays.toString(e));
        }
        System.out.println("====");
    }
        
}