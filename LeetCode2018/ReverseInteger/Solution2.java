import java.util.*;
public class Solution2{
    public int reverse(int x){
        int a = 0;
        while(x!=0){
            int c = x % 10;
            int b = a * 10 + c;
            if((b - c) / 10 != a){
                return 0;
            }
            a = b;
            x = x/10;
        }
        return a;
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
