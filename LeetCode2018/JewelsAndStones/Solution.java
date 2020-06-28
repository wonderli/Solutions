import java.util.*;
public class Solution{
    public int numJewelsInStones(String J, String S) {
        int[] map = new int[256];
        for(char c : J.toCharArray()){
            map[c - 'A']++;
        }
        int count = 0;
        for(char s : S.toCharArray()){
            if(map[s - 'A'] != 0){
                count++;
            }
        }
        return count;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
