//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
import java.util.*;
public class Solution{
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        char A[] = s.toCharArray();
        int len = A.length;
        for(int i = 0; i < len; i++){
            if(A[i] == '(' || A[i] == '[' || A[i] == '{'){
                stack.push(A[i]);
            }
            else{
                if(!stack.empty() && match((Character)stack.peek(), A[i])){
                    stack.pop();
                }else return false;
                
            }
        }
        return stack.empty();
    }
    public boolean match(char a, char b){
        if(a == '(' && b == ')') return true;
        if(a == '{' && b == '}') return true;
        if(a == '[' && b == ']') return true;
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String a = "()[{}";
        System.out.println(sol.isValid(a));
    }
}
