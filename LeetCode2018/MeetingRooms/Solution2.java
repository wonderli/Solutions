import java.util.*;
public class Solution2{
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <= 1) return true;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        for(int[] e : intervals){
            pq.add(e);
        }

        int[] first = pq.poll();
        int start = first[0];
        int end = first[1];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] < end){
                return false;
            }

            start = curr[0];
            end = curr[1];
        }
        return true;

    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
