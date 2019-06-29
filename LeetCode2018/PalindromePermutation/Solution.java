import java.util.*;
public class Solution{
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        char[] sArr = s.toCharArray();
        Map<Character, Integer> dict = new HashMap<>();
        for(int i = 0; i < sArr.length; i++){
            if(dict.get(sArr[i]) == null){
                dict.put(sArr[i], 1);
            }else {
                int v = dict.get(sArr[i]);
                v++;
                if(v == 2){
                    v = 0;
                }
                dict.put(sArr[i], v);
            }
        }
        int val = 0;
        Collection<Integer> values = dict.values();
        for(Integer e : values){
            val += e;
        }
        return (val == 0 && sArr.length % 2 == 0) || (val == 1 && sArr.length % 2 == 1);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.canPermutePalindrome("code"));
        System.out.println(sol.canPermutePalindrome("abb"));
        System.out.println(sol.canPermutePalindrome("carerac"));
        System.out.println(sol.canPermutePalindrome("AaBb//a"));
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
