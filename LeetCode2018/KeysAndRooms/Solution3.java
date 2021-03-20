import java.util.*;
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty()){
            int room = queue.poll();
            List<Integer> keys = rooms.get(room);
            for(int k : keys){
                if(!visited.contains(k)){
                    visited.add(k);
                    queue.add(k);
                }
            }
        }
        return visited.size() == n;
        
    }
}
