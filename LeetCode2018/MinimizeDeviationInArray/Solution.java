import java.util.*;
public class Solution {
    public int minimumDeviation(int[] nums) {

        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b - a));
        int min = Integer.MAX_VALUE;
        for(int e : nums){
            if(e % 2 == 0){
                pq.add(e);
                min = Math.min(min, e);
            }else {
                pq.add(e * 2);
                min = Math.min(min, e * 2);
            }
        }
        
        int minD = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            minD = Math.min(minD, curr - min);
            if(curr % 2 == 0){
                pq.add(curr/2);
                min = Math.min(min, curr/2);
            }else{
                break;
            }
        }
        return minD;
    }
}