import java.util.*;
class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites){
            int a = p[0];
            int b = p[1];
            List<Integer> list = map.getOrDefault(b, new ArrayList<>());
            list.add(a);
            map.put(b, list);
        }
        
        boolean[] visited= new boolean[numCourses];
        for(int i =0;i < numCourses;i++){
            if(!dfs(i, map, visited)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int index, Map<Integer, List<Integer>> map, boolean[] visited){
        if(visited[index]){
            return false;
        }
        visited[index] = true;
        List<Integer> list = map.get(index);
        if(list == null){
            list = new ArrayList<>();
        }
        for(int e : list){
            if(!dfs(e, map, visited)){
                return false;
            }
        }
        visited[index] = false;
        return true;
    }
}
