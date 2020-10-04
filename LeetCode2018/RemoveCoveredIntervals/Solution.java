import java.util.*;
public class Solution{
    public int removeCoveredIntervals(int[][] intervals) {
        List<Interval> list =new ArrayList<>();


        for(int i = 0; i< intervals.length; i++){
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            list.add(interval);
        }

        Collections.sort(list,
                new Comparator<Interval>(){
                    @Override
                    public int compare(Interval o1, Interval o2){
                        if(o1.a == o2.a){
                            return o2.b - o1.b;
                        }else{
                            return o1.a - o2.a;
                        }
                    }
                }
        );
        int count = 0;
        int prevEnd = 0;
        int end = 0;
        for(int i = 0; i < list.size(); i++){
            Interval curr = list.get(i);
            end = curr.b;
            if(prevEnd < end){
                count++;
                prevEnd = end;
            }
        }

        return count;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
//        int[][] a = {{1,4},{3,6},{2,8}};
        int[][] b ={{3,10},{4,10},{5,11}};
        System.out.println(sol.removeCoveredIntervals(b));
    }
}
class Interval{
    int a;
    int b;
    Interval(int a, int b){
        this.a = a;
        this.b = b;
    }

    public String toString(){
        return String.format("[%d, %d]", a, b);
    }
}

