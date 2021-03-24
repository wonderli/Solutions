import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i = 0; i < n; i++){
            pq.add(new int[]{i, B[i]});
        }
        int slow = 0;
        int fast = n - 1;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[1] >= A[fast]){
                C[curr[0]] = A[slow];
                slow++;
            }else{
                C[curr[0]] = A[fast];
                fast--;
            }
        }
        return C;
    }
}