import java.util.*;
public class Solution2{
    public boolean backspaceCompare(String S, String T) {
        String s = build(S);
        String t = build(T);
        return s.equals(t);
    }
    private String build(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        String a = "bbb#extm";
        String b = "bbb#extm";
        System.out.println(sol.backspaceCompare(a, b));
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
