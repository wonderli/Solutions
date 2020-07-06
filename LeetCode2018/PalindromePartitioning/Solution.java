import java.util.*;
public class Solution{
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        List<String> curr = new ArrayList<>();
        helper(0, s, curr, res);
        return res;
    }
    public void helper(int index, String s, List<String> curr, List<List<String>> res){
        if(s.isEmpty()){
            res.add(curr);
            return;
        }
        for(int i = index; i < s.length(); i++){
            String sub = s.substring(0, i+1);
            if(isPalindrome(sub)){
                List<String> tmp = new ArrayList<>(curr);
                curr.add(sub);
                helper(index+1, s.substring(i+1), curr, res);
                curr = tmp;
            }
        }
    }
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.partition("aab"));
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
