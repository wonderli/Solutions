import java.util.*;
class Solution {
    public int largestUniqueNumber(int[] A) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b - a));
        for(int a : A){
            if(!set.contains(a)){
                pq.add(a);
                set.add(a);
            }else{
                pq.remove(a);
            }
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}
