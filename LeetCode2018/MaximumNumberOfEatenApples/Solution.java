import java.util.*;
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        int result = 0;
        for(int i = 0; i < n || !pq.isEmpty(); i++){
            if(i < n) {
                pq.add(new int[]{i + days[i], apples[i]});
            }
            while(!pq.isEmpty() && (i >= pq.peek()[0] || pq.peek()[1] <= 0)){
                pq.poll();
            }
            if(!pq.isEmpty()){
                result++;
                pq.peek()[1]--;
            }
        }
        return result;
    }
}