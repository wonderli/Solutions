import java.util.*;
public class Solution{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals == null) {
            ArrayList<Interval> ret = new ArrayList<Interval>();
            ret.add(newInterval);
            return ret;
        }
        ArrayList<Interval> ret = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator(){
            public int compare(Object o1, Object o2){
                Interval a = (Interval)o1;
                Interval b = (Interval)o2;
                return a.start - b.start;
            }

        });
        int start = newInterval.start;
        int end = newInterval.end;
        int len = intervals.size();
        for(int i = 0; i < len; i++){
            if(end < intervals.get(i).start){
                ret.add(new Interval(start, end));
                for(int j = i; j < len; j++){
                    ret.add(intervals.get(j));
                }
                return ret;
            }
            if(start > intervals.get(i).end){
                ret.add(intervals.get(i));
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
    Interval() { start = 0; end = 0; }
    Interval(int s, int e){ start = s; end = e;}
}
