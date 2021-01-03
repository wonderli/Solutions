import java.util.*;
class Solution {
    int mod = 1000000007;
    public int countPairs(int[] d) {
        int n = d.length;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int e : d){
            int power = 1;
            for(int i = 0; i < 32; i++){
                if(map.containsKey(power - e)){
                    result += map.get(power - e);
                    result %= mod;
                }
                power *= 2;
            }
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        return result;
    }
}