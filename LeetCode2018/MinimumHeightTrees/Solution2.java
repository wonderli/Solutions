class Solution2 {
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
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(adj.get(i).size() == 1){
                queue.add(i);
            }
        }
        while(n > 2){
            int size = queue.size();
            n -= size;
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                Set<Integer> set = adj.get(curr);
                for(int e : set){
                    adj.get(e).remove((Integer)curr);
                    if(adj.get(e).size() == 1){
                        queue.add(e);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}