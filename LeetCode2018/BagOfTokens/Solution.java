import java.util.*;
public class Solution{
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        int res = 0;
        while(l <= r && (P >= tokens[l] || score > 0)){
            while(l <= r && P >= tokens[l]){
                P -= tokens[l];
                l++;
                score++;
            }
            res = Math.max(res, score);
            if(l <= r && score > 0){
                P += tokens[r];
                r--;
                score--;
            }
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
