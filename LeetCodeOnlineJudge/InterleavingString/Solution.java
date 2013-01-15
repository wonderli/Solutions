// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",
//
// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false. 
public class Solution{
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;
        return helper(s1,s2, s3, 0, 0);
    }
    public boolean helper(String s1, String s2, String s3, int i, int j){
        if(i + j == s3.length()){
            return true;
        }
        if((i < s1.length()) && s1.charAt(i) == s3.charAt(i + j)){
            if(helper(s1, s2, s3, i + 1, j)){
                return true;
            }
        }
        if((j < s2.length()) && s2.charAt(j) == s3.charAt(i + j)){
            if(helper(s1, s2, s3, i, j + 1)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        String s1 = new String("a");
        String s2 = new String("b");
        //String s3 = new String("aadbbcbcac");
        String s3 = new String("ab");
        System.out.println(s.isInterleave(s1, s2, s3));

    }
}
