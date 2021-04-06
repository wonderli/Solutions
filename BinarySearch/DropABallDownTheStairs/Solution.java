import java.util.*;

class Solution {
    long mod =1000000007;
    public int solve(int height, int[] blacklist) {
        Long[][] cache = new Long[height+1][2];
        Set<Integer> ban = new HashSet<>();
        for(int e : blacklist){
            ban.add(e);
        }
        long result = solve(height, ban, 0, cache);
        
        return (int) result;
    }

    private long solve(int height, Set<Integer> ban, int round, Long[][] cache){
        
        if(height < 0) return 0;
         if(ban.contains(height)){
            return 0;
        }
        if(cache[height][round] != null){
            return cache[height][round];
        }
        if(height == 0){
            return 1;
        }
        
        int result = 0;
        if(round == 0){
            cache[height][round] = (solve(height - 1, ban, 1, cache) + solve(height - 2, ban, 1, cache) + solve(height - 4, ban, 1, cache))%mod;
        }else{
            cache[height][round] = (solve(height - 1, ban, 0, cache) + solve(height - 3, ban, 0, cache) + solve(height - 4, ban, 0, cache))%mod;
        }

        return cache[height][round];
    }
}