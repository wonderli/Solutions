// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
public class Solution{
    public int minCut(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int dp[] = new int[len];
        boolean table[][] = new boolean[len][len];
        for(int i = 0; i < len; i++){
            for(int x = i, y = i; x >= 0 && y < len && s.charAt(x) == s.charAt(y); x--, y++){
                table[x][y] = true;
            }
            for(int x = i, y = i+1; x >= 0 && y < len && s.charAt(x) == s.charAt(y); x--, y++){
                table[x][y] = true;
            }
        }
        for(int i = 0; i < len; i++){
            dp[i] = -1;
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= i; j++){
                if(!table[j][i]) continue;
                if(j == 0){
                    dp[i] = 0;
                    continue;
                }
                if(dp[j - 1] == -1) continue;
                if(dp[i] == -1 || dp[j - 1] + 1 < dp[i]){
                    dp[i] = dp[j - 1] + 1;
                }
            }
        }
        return dp[len - 1];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String a = new String("aab");
        System.out.println(sol.minCut(a));
    }
}
