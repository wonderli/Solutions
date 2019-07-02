import java.util.*;
public class Solution2{
    public boolean isValid(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                char top = stack.empty() ? '#' : stack.pop();
                if(top != map.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.empty();
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
