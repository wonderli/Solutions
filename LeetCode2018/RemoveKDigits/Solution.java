import java.util.*;
public class Solution{
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for(char digit : num.toCharArray()){
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit){
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        for(int i = 0; i < k; i++){
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZeros = true;
        for(char digit : stack){
            if(leadingZeros && digit == '0') continue;
            leadingZeros = false;
            sb.append(digit);
        }
        final String s = sb.toString();
        return s.isEmpty() ? "0" : s;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
