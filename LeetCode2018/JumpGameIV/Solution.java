import java.util.*;
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n <= 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n-1);
        visited.add(n-1);
        int result = 0;
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i = 0; i < size; i++){
                int index = queue.poll();
                if(index == 0){
                    return result;
                }       
                List<Integer> candidates = map.get(arr[index]);
                candidates.add(index+1);
                candidates.add(index-1);
                for(int e : candidates){
                    if(e >= 0 && e < n && !visited.contains(e)){
                        queue.add(e);
                        visited.add(e);
                    }
                }
                candidates.clear();
            }
            result++;
        }
        return result;
    }
}