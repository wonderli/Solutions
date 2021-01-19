import java.util.*;
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : arr){
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for(int e : map.keySet()){
            pq.add(new int[]{e, map.get(e)});
        }
        while(!pq.isEmpty() && k != 0){
            pq.peek()[1]--;
            if(pq.peek()[1] == 0){
                pq.poll();
            }
            k--;
        }
        return pq.size();
    }
}