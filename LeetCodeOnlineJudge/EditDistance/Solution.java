//Edit Distance
//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character
public class Solution{
    public int minDistance(String word1, String word2) {
        if(word1 == null||word2 == null) return 0;
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0){
            return len2;
        }
        if(len2 == 0){
            return len1;
        }
        char w1[] = word1.toCharArray();
        char w2[] = word2.toCharArray();
        int dp[][] = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j;
        }
        int cost = 0;
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(w1[i - 1] == w2[j - 1]){
                    cost = 0;
                }else{
                    cost = 1;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1), dp[i-1][j-1] + cost);
            }
        }
        return dp[len1][len2];
    }
    public static void main(String args[]){
        String a = new String("sea");
        String b = new String("ate");
        Solution s = new Solution();
        System.out.println(s.minDistance(a, b));
    }
}
