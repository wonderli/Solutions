import java.util.*;
class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            graph.computeIfAbsent(e[0], (k -> new ArrayList<>())).add(e[1]);
        }
        Set<Integer> visited = new HashSet<>();
        return helper(graph, visited, source, destination);
    }
    private boolean helper(Map<Integer, List<Integer>> graph, Set<Integer> visited, int source, int destination){
        if(visited.contains(source)) return false;
        
        List<Integer> neighbors = graph.get(source);
        if(neighbors == null) return source == destination;
        visited.add(source);
        for(int e : neighbors){
            if(!helper(graph, visited, e, destination)){
                return false;
            }
        }
        visited.remove(source);
        return true;
        
    }
}
