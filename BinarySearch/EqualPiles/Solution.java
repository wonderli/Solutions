import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e, map.getOrDefault(e, 0)+1);            
        }
        // System.out.println(map);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(b[0]-a[0]));

        for(int e : map.keySet()){
            pq.add(new int[]{e, map.get(e)});
        }
        int count = 0;
        int prev = 0;
        while(pq.size() > 1){
            int[] curr = pq.poll();
            int a = curr[0];
            int b = curr[1];
            pq.peek()[1] += b;
            count += b;
        }
        return count;

    }
}
