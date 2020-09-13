import java.util.*;
public class Solution{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] status = new int[rooms.size()];
        status[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                List<Integer> list = rooms.get(curr);
                status[curr] = 1;
                for(int e : list){
                    if(status[e] == 0){
                        queue.add(e);
                    }
                }
            } 
        }
        for(int i = 0; i < status.length; i++){
            if(status[i] == 0){
                return false;
            }
        }
        return true;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

