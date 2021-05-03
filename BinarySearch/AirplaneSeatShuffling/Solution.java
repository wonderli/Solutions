class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            graph.computeIfAbsent(e[0], (k -> new ArrayList<>())).add(e[1]);
            graph.computeIfAbsent(e[1], (k -> new ArrayList<>())).add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(Map<Integer, List<Integer>> graph, int index, Set<Integer> visited){
        if(visited.contains(index)) return;
        visited.add(index);
        List<Integer> list = graph.getOrDefault(index, new ArrayList<>());
        for(int e : list){
            if(!visited.contains(e)){
                dfs(graph, e, visited);
            }
        }
    }
}