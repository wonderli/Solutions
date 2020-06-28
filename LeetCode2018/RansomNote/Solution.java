import java.util.*;
public class Solution{
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[256];
        for(char m : magazine.toCharArray()){
            map[m - 'a']++;
        }
        for(char r : ransomNote.toCharArray()){
        	map[r - 'a']--;
        	int num = map[r - 'a'];
            if(num < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        String j = "aa";
        String m = "ab";
        System.out.println(sol.canConstruct(j, m));
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
