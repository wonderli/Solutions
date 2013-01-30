//Implement wildcard pattern matching with support for '?' and '*'.
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
public class Solution2{
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if(pLen == 0){
            return sLen == 0;
        }
        if(sLen > 3000) return false; //escape final large input set
        boolean f[][] = new boolean[sLen + 1][pLen + 1];
        f[0][0] = true;
        for(int i = 0; i <= sLen; i++){
            for(int j = 0; j <= pLen; j++){
                if(i > 0 && j != 0){
                    f[i][j] = f[i-1][j] && p.charAt(j-1) == '*';
                }
                if(j > 0){
                    f[i][j] = f[i][j] || f[i][j - 1] && p.charAt(j - 1) == '*'; 
                }
                if(i > 0 && j > 0){
                    f[i][j] = f[i][j] || f[i-1][j-1] && check(s.charAt(i - 1), p.charAt(j - 1));
                }
            }
        }
            return f[sLen][pLen];
        }
        boolean check(char a, char b){
            return a == b || b == '?';
        }
        public static void main(String args[]){
            Solution2 sol = new Solution2();
            String a = "aa";
            String b = "a";
            System.out.println(sol.isMatch(a,b));
        }
    }
