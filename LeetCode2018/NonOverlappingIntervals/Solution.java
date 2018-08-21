import java.util.*;
public class Solution{
     public int eraseOverlapIntervals(Interval[] intervals) {
         if(intervals == null || intervals.length == 0) return 0;
         Arrays.sort(intervals, new Comparator<Interval>() {
             @Override
             public int compare(Interval o1, Interval o2){
                     return o1.end - o2.end;
             }
         });
         int end = intervals[0].end;
         int count = 1;
         for(int i = 1; i< intervals.length; i++){
             if(intervals[i].start >= end){
                 end = intervals[i].end;
                 count++;
             }
         }
         return intervals.length - count;
     }
    
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
