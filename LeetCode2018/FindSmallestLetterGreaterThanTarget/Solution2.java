import java.util.*;
public class Solution2{
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0; int r = letters.length;
        while(l < r){
            int mid = l + (r - l)/2;
            if(letters[mid] <= target){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return letters[l % letters.length];
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
