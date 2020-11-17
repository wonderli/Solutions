import java.util.*;
public class Solution2{
	public List<String> wordBreak(String s, List<String> wordDict) {
	        List<String> res = new ArrayList<>();
	        if(isWordBreak(s, wordDict)){
	            helper(s, "", new HashSet(wordDict), res);
	        }
	        return res;
	    }
    
	    private void helper(String s, String curr, Set<String> dict, List<String> res){
	        if(s.isEmpty()){
	            res.add(curr.trim());
	            return;
	        }
	        for(int i = 1; i <= s.length(); i++){
	            if(dict.contains(s.substring(0, i))){
	                helper(s.substring(i), curr + s.substring(0, i) + " ", dict, res);
	            }
            
	        }
	    }
    
	    private boolean isWordBreak(String s, List<String> wordDict){
	        int n = s.length();
	        boolean[] dp  =new boolean[n+1];
	        dp[0] = true;
	        for(int i = 1; i <= n; i++){
	            for(int j = 0; j < i; j++){
	                if(dp[j] && wordDict.contains(s.substring(j, i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[n];
	    }
		
		
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
