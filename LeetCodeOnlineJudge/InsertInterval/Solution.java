//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//You may assume that the intervals were initially sorted according to their start times.
//
//Example 1:
//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//Example 2:
//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
import java.util.*;
public class Solution{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals.size() < 1){
            ArrayList<Interval> ret = new ArrayList<Interval>();
            ret.add(newInterval);
            return ret;
        }
        ArrayList<Interval> ret = new ArrayList<Interval>();
        Iterator<Interval> iter = intervals.iterator();
        while(iter.hasNext()){
            Interval n = iter.next();
            if(newInterval.end < n.start){
                ret.add(newInterval);
                ret.add(n);
                while(iter.hasNext()){
                    ret.add(iter.next());
                }
                return ret;
            }
            if(newInterval.start > n.end){
                ret.add(n);
            }else{
                newInterval.start = Math.min(newInterval.start, n.start);
                newInterval.end = Math.max(newInterval.end, n.end);
            }
        }
        ret.add(newInterval);
        return ret;
    }
      
    public static void main(String args[]){
        Solution s = new Solution();
        ArrayList<Interval> input = new ArrayList<Interval>();
        Interval num1 = new Interval(1, 5);
        Interval newInterval = new Interval(6,8);
        input.add(num1);

        ArrayList<Interval> output = s.insert(input, newInterval);
        for(Interval e : output){
            System.out.println("[" + e.start + " " + e.end + "]");
        }
    }
}

