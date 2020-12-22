import java.util.*;
public class Solution2{
	int timer = 0;
	    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        for(List<Integer> connection : connections){
	            int a = connection.get(0);
	            int b= connection.get(1);
	            graph.computeIfAbsent(a, (k -> new ArrayList<>())).add(b);
	            graph.computeIfAbsent(b, (k -> new ArrayList<>())).add(a);
	        }
	        boolean[] visited = new boolean[n];
	        int[] lowLinkNode = new int[n];
	        List<List<Integer>> result = new ArrayList<>();
	        dfs(graph, -1, 0, visited, lowLinkNode, result);
	        return result;
	    }
	    private void dfs(Map<Integer, List<Integer>> graph, int parent, int curr, boolean[] visited, int[] lowLinkNode, List<List<Integer>> result){
	        visited[curr] = true;
	        int currTimer = timer;
	        timer++;
	        lowLinkNode[curr] = currTimer;
        
	        for(int n : graph.get(curr)){
	            if(n == parent) continue;
	            if(!visited[n]){
	                dfs(graph, curr, n, visited, lowLinkNode, result);
	            }
	            lowLinkNode[curr] = Math.min(lowLinkNode[curr], lowLinkNode[n]);
	            if(currTimer < lowLinkNode[n]){
	                result.add(Arrays.asList(curr, n));
	            }
	        }
	    }
}