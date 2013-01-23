//Implement regular expression matching with support for '.' and '*'.
public class Solution{
    public boolean isMatch(String s, String p){
        int sLen = s.length();
        int pLen = p.length();
        if(pLen == 0) return sLen == 0;
        if(pLen == 1 ||p.charAt(1) != '*'){
            if(sLen < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))){
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        }else{
            int i = -1;
            while((i < sLen) && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "aa";
        String p = "a*";
        System.out.println(sol.isMatch(s, p));
    }
}
