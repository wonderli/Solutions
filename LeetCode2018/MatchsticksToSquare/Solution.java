import java.util.*;
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = getSum(matchsticks);
        
        if(sum % 4 != 0) return false;
        int[] sums = new int[4];
        return dfs(matchsticks, 0, sum/4, sums);
    }
    
    private boolean dfs(int[] matchsticks, int index, int target, int[] sums){
        if(index == matchsticks.length){
            if(target == sums[0] && target == sums[1] && target == sums[2] && target == sums[3]){
                return true;
            }
            return false;
        }
        
        for(int i = 0; i < 4; i++){
            if(sums[i] + matchsticks[index] > target){
                continue;
            }
            
            sums[i] += matchsticks[index];
            if(dfs(matchsticks, index+1, target, sums)){
                return true;
            }
            sums[i] -= matchsticks[index];
        }
        return false;
    }
    
    private int getSum(int[] matchsticks){
        int sum = 0;
        for(int e : matchsticks){
            sum += e;
        }
        return sum;
    }
}
