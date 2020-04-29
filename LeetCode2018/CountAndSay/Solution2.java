import java.util.*;
public class Solution2{
    public String countAndSay(int n) {
        if(n == 1) return "1";
        if(n == 2) return "11";
        return count(countAndSay(n-1));
    }
    public String count(String s){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int count = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(i -1)){
                count++;
            }else{
                sb.append(Integer.toString(count)).append(s.charAt(i-1));
                count = 1;
            }
            i++;
        }
        sb.append(Integer.toString(count)).append(s.charAt(i-1));
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
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
