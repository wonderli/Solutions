import java.util.*;
public class Solution{
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(start == null || end == null) return 0;
        if(start.equals(end) && dict.isEmpty()) return 0;
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> curr = new ArrayList<String>();
        curr.add(start);
        //int min = Integer.MAX_VALUE;
        int min[] = new int[1];
        min[0] = Integer.MAX_VALUE;
        helper(start, end, dict, result, curr, 0, min);
        //for(ArrayList<String> e : result){
        //    min = Math.min(min, e.size());
        //}
        return min[0] == Integer.MAX_VALUE ? 0 : min[0];
    }
    public void helper(String start, String end, HashSet<String> dict, ArrayList<ArrayList<String>> result, ArrayList<String> curr, int time, int min[]){
        if(time > dict.size() + 1) return;
        int d = getDistance(start, end);
        if(d == 1){
            curr.add(end);
            result.add(curr);
            min[0] = Math.min(min[0], curr.size());
            return;
        }
        for(String e : dict){
            int dist = getDistance(start, e);
            if(dist == 1){
                ArrayList<String> tmp = new ArrayList<String>(curr);
                curr.add(e);
                helper(e, end, dict, result, curr, time + 1, min);
                curr = tmp;
            }
        }
    }
    public int getDistance(String start, String end){
        int dist = 0;
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) != end.charAt(i)){
                dist++;
            }
        }
        return dist;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "ta";
        String e = "if";
        HashSet<String> set = new HashSet<String>();
        set.add("ts");
        set.add("sc");
        set.add("ph");
        set.add("ca");
        set.add("jr");
        set.add("hf");
        set.add("to");
        set.add("if");
        set.add("ha");
        set.add("is");
        set.add("io");
        set.add("cf");
        set.add("ta");
        int ret = sol.ladderLength(s, e, set);
        System.out.println(ret);
    }
}
