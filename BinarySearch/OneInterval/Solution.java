import java.util.*;
/**
You are given a two-dimensional list of integers intervals where each list represents an inclusive [start, end] interval. For an interval [a, b] (where a < b), its size is defined as b - a.

You must add one interval to the given list such that, after merging all the intervals, you get exactly one range left.

Return the minimum possible size of the added interval.

Constraints

0 ≤ n ≤ 100,000 where n is the length of intervals.
Example 1
Input
intervals = [
    [10, 20],
    [25, 100]
]
Output
5
Explanation
We can add the interval [20, 25] which is the smallest possible interval.

*/
class Solution {
    public int solve(int[][] intervals) {
        List<List<Integer>> merged = merge(intervals);
        if(merged.size() == 1) return 0;
        int l = merged.get(0).get(1);
        int r = merged.get(merged.size() - 1).get(0);
        return r - l;
    }
    private List<List<Integer>> merge(int[][] intervals){
        Arrays.sort(intervals, (a, b)->(a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<List<Integer>> list = new ArrayList<>();
        int n = intervals.length;
        for(int i = 1; i < n; i++){
            int[] curr = intervals[i];
            if(curr[0] <= end){
                end = Math.max(end, curr[1]);
            }else{
                list.add(Arrays.asList(start, end));
                start = curr[0];
                end = curr[1];
            }
        }
        list.add(Arrays.asList(start, end));
        return list;
    }
}