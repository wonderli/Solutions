import java.util.*;

public class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        int[] lowLinkValues = new int[n];
        int time = 0;
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs(i, i, visited, lowLinkValues, graph, time, result);
            }
        }
        return result;
    }

    private void dfs(int currVertex, int parentVertex, boolean[] visited, int[] lowLinkValues, Map<Integer,
            List<Integer>> graph, int time, List<List<Integer>> result) {
        time++;
        lowLinkValues[currVertex] = time;
        int discoverValue = time;
        visited[currVertex] = true;
        for (int v : graph.get(currVertex)) {
            if (v == parentVertex) continue;
            if (!visited[v]) {
                dfs(v, currVertex, visited, lowLinkValues, graph, time, result);
                if (discoverValue < lowLinkValues[v]) {
                    result.add(Arrays.asList(currVertex, v));
                }
            }
            lowLinkValues[currVertex] = Math.min(lowLinkValues[currVertex], lowLinkValues[v]);
        }
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
    }
}
