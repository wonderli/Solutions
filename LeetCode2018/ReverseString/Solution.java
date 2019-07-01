import java.util.*;
public class Solution{
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;

        int i = 0;
        int j = s.length - 1;
        while(i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));
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
