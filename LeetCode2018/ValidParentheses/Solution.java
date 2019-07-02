import java.util.*;
public class Solution{
    public boolean isValid(String s) {
        if(s == null||s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isLeftParenthese(c)){
                stack.push(c);
            }else if(isRightParethese(c)){
                char left = stack.pop();
                if(!isMatch(left, c)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isLeftParenthese(char c){
        return c == '[' || c == '(' || c == '{';
    }
    public boolean isRightParethese(char c){
        return c == ']' || c == ')' || c == '}';
    }
    public boolean isMatch(char left, char right){
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.isValid("()[]{}"));
        System.out.println(sol.isValid("(]"));
        System.out.println(sol.isValid("{[]}"));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
