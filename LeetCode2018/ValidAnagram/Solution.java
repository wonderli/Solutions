import java.util.*;
public class Solution{
    public boolean isAnagram(String s, String t) {
        if((s == null && t != null) || (s != null && t == null)) return false;
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < sLen; i++){
            if(sMap.get(s.charAt(i)) == null){
                sMap.put(s.charAt(i), 1);
            }else{
                int num = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), num + 1);
            }
        }
        for(int i = 0; i < tLen; i++){
            char c = t.charAt(i);
            if(sMap.get(c) == null){
                return false;
            }else{
                int num = sMap.get(c);
                if(num == 1) {
                    sMap.remove(c);
                }else {
                    sMap.put(c, num -1);
                }
            }
        }
        return sMap.isEmpty();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(sol.isAnagram(s, t));
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
