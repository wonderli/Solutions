//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18]. 
import java.util.*;
public class Solution{
     public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
         if(intervals.size() < 2) return intervals;
         Collections.sort(intervals, new Comparator<Object>(){
            public  int compare(Object a, Object b){
                 Interval c = (Interval)a;
                 Interval d = (Interval)b;
                 if(c.start < d.start) return -1;
                 else if(c.start > d.start) return 1;
                 else return 0;
             }
         });

         ArrayList<Interval> ret = new ArrayList<Interval>();
         int start = intervals.get(0).start;
         int end = intervals.get(0).end;
         for(int i = 0; i < intervals.size(); i++){
             Interval curr = intervals.get(i);
             if(end >= curr.start){
                 end = Math.max(end, curr.end);
             }else{
                 ret.add(new Interval(start, end));
                 start = curr.start;
                 end = curr.end;
             }
         }
         ret.add(new Interval(start, end));
         return ret;
     }
    public static void main(String args[]){
        Solution sol = new Solution();
        ArrayList<Interval> a = new ArrayList<Interval>();
        //a.add(new Interval(1,3));
        //a.add(new Interval(2, 6));
        //a.add(new Interval(8, 10));
        //a.add(new Interval(15, 18));
        a.add(new Interval(1,4));
        a.add(new Interval(0,0));
        ArrayList<Interval> ans = sol.merge(a);
        for(Interval e : ans){
            System.out.print("[" + e.start + "," + e.end + "]" + " ");
        }

    }
}
