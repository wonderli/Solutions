import java.util.*;

public class Solution2 {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for(char c : t.toCharArray()){
            map[c]++;
        }
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        while(end < s.length()){
            char c1 = s.charAt(end);
            if(map[c1] > 0) count--;
            map[c1]--;
            end++;
            while(count == 0){
                if(minLen > end - start){
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if(map[c2] > 0) count++;
                start++;
            }
        }
        return  minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String args[]) {
        Solution2 sol = new Solution2();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
