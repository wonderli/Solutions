import java.util.*;
public class Solution{
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }
    public void helper(List<String> res, String word, int index, String curr, int count){
        if(index == word.length()){
            if(count > 0) curr += count;
            res.add(curr);
            return;
        }

        helper(res, word, index+1, curr, count + 1);
        helper(res, word, index+1, curr + (count > 0 ? count : "") + word.charAt(index) , 0);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String word = "word";
        System.out.println(sol.generateAbbreviations(word));
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
