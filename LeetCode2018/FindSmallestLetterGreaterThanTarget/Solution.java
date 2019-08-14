import java.util.*;
public class Solution{
    public char nextGreatestLetter(char[] letters, char target) {
        int[] arr = new int[256];
        for(int i = 0; i < letters.length; i++){
            arr[letters[i] - 'a']++;
        }
        while(true){
            target++;
            if(target > 'z') target = 'a';
            if(arr[target - 'a'] > 0) return target;
        }

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
