//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
public class Solution2{
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return new String();
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append("*");
        }
        s = sb.toString();
        int start = 0;
        int len = s.length();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            int low = i - 1;
            int high = i + 1;
            int curr = s.charAt(i) == '*' ? 0 : 1;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                    curr += 2;
                    if(curr > max){
                        max = curr;
                        start = low;
                    }
                    low--;
                    high++;
            }
        }
        String str = s.substring(start, start + max);
        sb = new StringBuilder();
        for(int i = start; i < start + max; i++){
            if(s.charAt(i) != '*'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        String s = new String("aaaa");
        System.out.println(sol.longestPalindrome(s));
    }
}
