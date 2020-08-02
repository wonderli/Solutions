import java.util.*;
public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        List<Interval> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            list.add(interval);
        }
        Collections.sort(list);
        List<Interval> res = new ArrayList<>();
        int start = list.get(0).first;
        int end = list.get(0).second;
        for(int i = 0; i < list.size(); i++){
            Interval curr = list.get(i);
            if(end >= curr.first){
                end = Math.max(end, curr.second);
            }else {
                res.add(new Interval(start, end));
                start = curr.first;
                end = curr.second;
            }
        }
        res.add(new Interval(start, end));
        int[][] ret = get(res);
        return ret;
    }
    public int[][] get(List<Interval> list){
        int[][] ret = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ret[i][0] = list.get(i).first;
            ret[i][1] = list.get(i).second;
        }
        return ret;
    }
}
class Interval implements Comparable<Interval>{
    int first;
    int second;
    Interval(int first, int second){
        this.first = first;
        this.second = second;
    }
    
    @Override
    public int compareTo(Interval o){
        return this.first - o.first;
    }
}
