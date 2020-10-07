import java.util.*;
public class Solution2{
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[]b){
                return a[0] -b[0];
            }
        });
        PriorityQueue<Integer> allocator = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });

        allocator.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= allocator.peek()){
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
