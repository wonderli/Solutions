// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
//
//   [
//       ["aa","b"],
//       ["a","a","b"]
//   ]
//
import java.util.*;
public class Solution{
    public ArrayList<ArrayList<String>> partition(String s) {
        if(s == null) return null;
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> curr = new ArrayList<String>();
        if(s.length() == 0){
            ret.add(curr);
            return ret;
        }
        dfs(s, 0, ret, curr);
        return ret;
    }
    public void dfs(String s, int start, ArrayList<ArrayList<String>> ret, ArrayList<String> curr){
        if(start == s.length()){
            ret.add(curr);
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){
            if(checkPalindrome(s, start, i - 1)){
                ArrayList<String> t = new ArrayList<String>(curr);
                curr.add(s.substring(start, i));
                dfs(s, i, ret, curr);
                curr = t;
            }
        }
    }
    public boolean checkPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = new String("aab");
        ArrayList<ArrayList<String>> ret = sol.partition(s);
        for(ArrayList<String> e : ret){
            System.out.println(e);
        }
    }
}
