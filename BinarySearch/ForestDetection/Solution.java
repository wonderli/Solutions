import java.util.*;

class Solution {
    public boolean solve(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            map.computeIfAbsent(e[0], (k -> new ArrayList<>())).add(e[1]);
            map.computeIfAbsent(e[1], (k -> new ArrayList<>())).add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int key : map.keySet()){
            if(!visited.contains(key)){
                if(!dfs(map, visited, key, -1)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int index, int parent){
        visited.add(index);
        List<Integer> children = map.getOrDefault(index, new ArrayList<>());
        for(int e : children){
            if(e == parent) continue;
            else if(visited.contains(e)){
                return false;
            }else if(!dfs(map, visited, e, index)){
                return false;
            }
        }
        return true;
    }
}