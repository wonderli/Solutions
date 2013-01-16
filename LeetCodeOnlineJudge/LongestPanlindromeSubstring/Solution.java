//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
public class Solution{
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return new String();
        int len = s.length();
        int start = 0;
        int low = 0;
        int high = 0;
        int max = 1;
        for(int i = 1; i < len; i++){
            low = i - 1; 
            high = i;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > max){
                    max = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
            low = i - 1;
            high = i + 1;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > max){
                    max = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }

        }

        return s.substring(start, start + max);

    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = new String("aaaa");
        System.out.println(sol.longestPalindrome(s));
    }
}
