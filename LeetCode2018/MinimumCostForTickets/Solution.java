import java.util.*;
public class Solution{
    int[] days;
    int[] costs;
    Integer[] memo;
    Set<Integer> set;
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[366];
        set = new HashSet<>();
        for(int d : days){
            set.add(d);
        }
        return dp(1);
    }
    public int dp(int index){
        if(index > 365) return 0;
        if(memo[index] != null) return memo[index];
        int result = Integer.MAX_VALUE;
        if(set.contains(index)){
            result = Math.min(dp(index+1) + costs[0], dp(index+7)+ costs[1]);
            result = Math.min(result, dp(index+30) + costs[2]);
        }else{
            result = dp(index+1);
        }
        memo[index] = result;
        return result;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
