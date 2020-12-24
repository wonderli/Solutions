import java.util.*;
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));
        for(int[] point : points){
            pq.add(point);
            if(pq.size() > K){
                pq.poll();
            }
        }
        int[][] result = new int[K][2];
        int i = 0;
        while(!pq.isEmpty()){
            result[i] = pq.poll();
            i++;
        }
        return result;
    }
    
    private int getDistance(int[] point){
        int a = point[0];
        int b = point[1];
        return a * a + b * b;
    }
}