class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 0) return new ArrayList<>(); 
        if(n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new HashSet<>());
        }
        
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }
        
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves){
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1){
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        
       
        return leaves;
    }
}