//Longest Valid Parentheses
//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
public class Solution{
    public int longestValidParentheses(String s) {
        if(s == null||s.length() < 2) return 0;
        int p = 0;
        int last = 0;
        int len = s.length();
        int max = 0;
        for(int i = 0; i < len; i++){

            if(s.charAt(i) == '('){
                p++;
            }else if(s.charAt(i) == ')'){
                p--;
            }

            if(p == 0){
                int currLen = i - last + 1; 
                if(currLen > max){
                    max = currLen;
                }
            }

            if(p < 0){
                last = i + 1;
                p = 0;
            }
        }

        p = 0;
        last = len - 1;
        for(int i = len - 1; i >= 0; i--){

            if(s.charAt(i) == ')'){
                p++;
            }else if(s.charAt(i) == '('){
                p--;
            }

            if(p == 0){
                int currLen = last - i + 1; 
                if(currLen > max){
                    max = currLen;
                }
            }

            if(p < 0){
                last = i - 1;
                p = 0;
            }
        }


        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = new String("(()");
        System.out.println(sol.longestValidParentheses(s)); 
        //sol.longestValidParentheses(s);
    }
}
