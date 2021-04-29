import java.util.*;
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for(int[] e : slots1){
            if(e[1] - e[0] >= duration){
                pq.add(e);
            }
        }
        
        for(int[] e : slots2){
            if(e[1] - e[0] >= duration){
                pq.add(e);
            }
        }
        
        while(pq.size() > 1){
            int[] slot1 = pq.poll();
            int[] slot2 = pq.peek();
            if(slot1[1] >= slot2[0] + duration){
                return Arrays.asList(slot2[0], slot2[0] + duration);
            }
        }
        return new ArrayList<>();
    }
}