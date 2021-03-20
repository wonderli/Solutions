import java.util.*;
class Solution{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, visited, 0);
        for(boolean b : visited){
            if(!b){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, boolean[] visited, int from){
        List<Integer> keys = rooms.get(from);
        for(int k : keys){
            if(!visited[k]){
                visited[k] = true;
                dfs(rooms, visited, k);
            }
        }
    }
}

