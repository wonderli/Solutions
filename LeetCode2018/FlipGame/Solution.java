import java.util.*;
public class Solution{
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = -1; (i = s.indexOf("++", i+1)) >= 0;){
            res.add(s.substring(0, i) + "--" + s.substring(i+2));
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.generatePossibleNextMoves("++++"));
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
