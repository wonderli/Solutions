import java.util.*;
public class Solution{
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return intervals;
        Collections.sort(intervals, new Comparator(){
            public int compare(Object o1, Object o2){
                Interval a = (Interval)o1;
                Interval b = (Interval)o2;
                return a.start - b.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        int len = intervals.size();
        ArrayList<Interval> ret = new ArrayList<Interval>();
        for(int i = 1; i < len; i++){
            if(start > intervals.get(i).end){
                ret.add(intervals.get(i));
            }else if(end < intervals.get(i).start){
                ret.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }else{
                start = Math.min(start, intervals.get(i).start);
                end = Math.max(end, intervals.get(i).end);
            }
        }
        ret.add(new Interval(start, end));
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0;}
    Interval(int s, int e) {start = s; end = e;}
}
