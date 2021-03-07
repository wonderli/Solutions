import java.util.*;
import java.util.Map.Entry;
public class Solution2{
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 2) {
            return s.length();
        }
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while(i < s.length()  && j < s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)){
				set.add(c);
                max = Math.max(j - i + 1, max);
				j++;
            }else{
                set.remove(s.charAt(i));
				i++;
            }

        }
        return max;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        String a = "abcabcbb";
        System.out.println(sol.lengthOfLongestSubstring(a));
        String b = "bbbbbbb";
        System.out.println(sol.lengthOfLongestSubstring(b));
        String c = "pwwkew";
        System.out.println(sol.lengthOfLongestSubstring(c));
        String d = "awwkabc";
        System.out.println(sol.lengthOfLongestSubstring(d));
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
