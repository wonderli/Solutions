import java.util.*;
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();
        int n = pid.size();
        for(int i = 0; i < n; i++){
            int id = pid.get(i);
            int parentId = ppid.get(i);
            parentChildMap.computeIfAbsent(parentId, (k -> new ArrayList<>())).add(id);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        visited.add(kill);
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);
            for(int e : parentChildMap.getOrDefault(curr, new ArrayList<>())){
                if(!visited.contains(e)){
                    queue.add(e);
                    visited.add(e);
                }
            }
        }
        return result;
    }
}