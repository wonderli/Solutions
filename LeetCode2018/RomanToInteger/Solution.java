import java.util.*;
public class Solution{
    private static Map<String, Integer> map = createMap();
    
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("III"));
        System.out.println(sol.romanToInt("IV"));
        System.out.println(sol.romanToInt("IX"));
        System.out.println(sol.romanToInt("LVIII"));
        System.out.println(sol.romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) return map.get(s);

        if(s.charAt(0) == 'I' && s.charAt(1) == 'V') {
            return 4 + romanToInt(s.substring(2));
        }
        if(s.charAt(0) == 'I' && s.charAt(1) == 'X') {
            return 9 + romanToInt(s.substring(2));
        }
        if(s.charAt(0) == 'X' && s.charAt(1) == 'L') {
            return 40 + romanToInt(s.substring(2));
        }
        if(s.charAt(0) == 'X' && s.charAt(1) == 'C') {
            return 90 + romanToInt(s.substring(2));
        }
        if(s.charAt(0) == 'C' && s.charAt(1) == 'D') {
            return 400 + romanToInt(s.substring(2));
        }
        if(s.charAt(0) == 'C' && s.charAt(1) == 'M'){
            return 900 + romanToInt(s.substring(2));
        }
        return map.get(s.substring(0, 1)) + romanToInt(s.substring(1));
    
    }
    private static Map<String, Integer> createMap() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        return map;
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
