import java.util.*;
public class Solution3{
    Map<Character, Character> map = new HashMap<>();
    {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty() || (stack.peek() != map.get(c))){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
