//Implement wildcard pattern matching with support for '?' and '*'.
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
public class Solution{
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if(pLen == 0){
            return sLen == 0;
        }
        if(sLen == 0) return p.equals("") || checkAllStar(p);
        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'){
            return isMatch(s.substring(1), p.substring(1));
        }
        if(p.charAt(0) == '*'){
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        }
        return false;
    }
    public boolean checkAllStar(String p){
        int pLen = p.length();
        for(int i = 0; i < pLen; i++){
            if(p.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
