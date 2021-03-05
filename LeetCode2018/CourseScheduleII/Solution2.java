import java.util.*;
class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];
            indegrees.put(a, indegrees.getOrDefault(a, 0)+1);
            adjMap.computeIfAbsent(b, (k-> new ArrayList<>())).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees.getOrDefault(i, 0) == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);
            List<Integer> neighbors = adjMap.getOrDefault(curr, new ArrayList<>());
            for(int e :neighbors){
                int v = indegrees.get(e);
                v--;
                if(v == 0){
                    queue.add(e);
                }
                indegrees.put(e, v);
            }
        }
        if(result.size() != numCourses){
            return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
        return res;
        
    }
}