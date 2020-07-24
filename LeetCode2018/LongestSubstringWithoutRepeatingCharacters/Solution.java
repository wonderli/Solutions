import java.util.*;
import java.util.Map.Entry;
public class Solution{
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 2) {
            return s.length();
        }
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int curr = 0;
        while(i < s.length() - 1 && j < s.length()){
            char c = s.charAt(j);
            if(!map.containsKey(c)){
                curr++;
                max = Math.max(curr, max);
                map.put(c, j);
            }else{
            	int prev = map.get(c);
                i = prev + 1;
                List<Character> toBeDeleted = new ArrayList<>();
                for(Entry<Character, Integer> e : map.entrySet()) {
                	if(e.getValue() < prev) {
                		toBeDeleted.add(e.getKey());
                	}
                }
                for(Character tc : toBeDeleted) {
                	map.remove(tc);
                }
                map.put(c, j);
                curr = j - i + 1;
            }
            j++;
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
