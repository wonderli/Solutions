import java.util.*;
public class Solution{
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> all = new ArrayList<>();
        for(int i = 0; i < intervals.length;i++){
            all.add(intervals[i][0]);
            all.add(-1 * intervals[i][1]);
        }

        Collections.sort(all, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                int res = Math.abs(a) - Math.abs(b);
                if (res == 0) {
                    return a - b;
                } else {
                    return res;
                }
            }
        });
        int count = 0;
        int max = 0;
        for(int e : all){
            if(e >= 0){
                count++;
            }else{
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(sol.minMeetingRooms(intervals));
    }
}
