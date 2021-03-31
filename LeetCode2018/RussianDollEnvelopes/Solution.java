import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }else{
                    return a[0] - b[0];
                }
            }
        });
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] e : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, e[1]);
            if(index < 0){
                index = -(index+1);
            }
            dp[index] = e[1];
            if(index == len){
                len++;
            }
        }
        return len;
    }
}
