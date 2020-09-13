import java.util.*;
public class Solution2{
    int i = 0;
    public String decodeString(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String tmp = "";
        while(i < s.length()){
            char c = s.charAt(i);
            i++;
            if(c == '['){
                tmp = decodeString(s);
                for(int j = 0; j < count; j++){
                    sb.append(tmp);
                }
                count = 0;
            }else if(c == ']'){
                break;
            }else if(Character.isAlphabetic(c)){
                sb.append(c);
            }else {
                count = count * 10 + c -'0';
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
