//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
public class Solution{
    int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int dp[] = new int[len+1];
        dp[len] = 1;
        for(int i = len- 1; i >=0; i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i+1];
                if(i < len -1 && Integer.parseInt(s.substring(i, i+2)) <= 26){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
    public static void main(String args[]){
    }
}
