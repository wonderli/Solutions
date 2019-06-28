import java.util.*;
public class Solution{
    public boolean canAttendMeetings(int[][] intervals) {
        int len = intervals.length;
        if(len <= 1) return true;
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int[] currInterval = intervals[i];
            Pair curr = new Pair(currInterval[0], currInterval[1]);
            list.add(curr);
        }
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2){
                return p1.start - p2.start;
            }
        });
        Pair prev = list.get(0);
        for(int i = 1; i < len; i++){
            Pair curr = list.get(i);
            if(curr.start < prev.end){
                return false;
            }else{
                prev = curr;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Pair {
    int start;
    int end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
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
