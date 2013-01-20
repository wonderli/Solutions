//Minimum Window Substring
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
//
// Minimum window is "BANC".
//
// Note:
// If there is no such window in S that covers all characters in T, return the emtpy string "".
//
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
public class Solution{
    public String minWindow(String S, String T) {
        if(S.length() < T.length()) return new String();
        if(T.length() == 0) return S;
        int sLen = S.length();
        int tLen = T.length();
        int needToFind[] = new int[256];
        int hasFound[] = new int[256];
        for(int i = 0; i < 256; i++){
            needToFind[i] = 0;
            hasFound[i] = 0;
        }
        for(int i = 0; i < tLen; i++){
            needToFind[T.charAt(i)]++;
        }
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int minBegin = 0;
        int minEnd = 0;
        for(int begin = 0, end = 0; end < sLen; end++){
            if(needToFind[S.charAt(end)] == 0) continue;
            hasFound[S.charAt(end)]++;
            if(hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
                count++;
            if(count == tLen){
                while(needToFind[S.charAt(begin)] == 0 || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]){
                    if(hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]){
                        hasFound[S.charAt(begin)]--;
                    }
                    begin++;
                }

                int winLen = end - begin + 1;
                if(winLen < minLen){
                    minBegin = begin;
                    minEnd = end;
                    minLen = winLen;
                }
            }
        }
        if(count != tLen) return new String();
        return S.substring(minBegin, minBegin + minLen);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //String S = new String("ADOBECODEBANC");
        //String T = new String("ABC");
        String S = new String("A");
        String T = new String("B");
        System.out.println(sol.minWindow(S, T));
    }
}
