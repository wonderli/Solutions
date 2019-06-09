import java.util.*;
public class Solution2{
    public boolean isHappy(int n) {
        int slow = calculate(n);
        int fast = calculate(calculate(n));
        while(slow != fast){
            slow = calculate(slow);
            fast = calculate(calculate(fast));
        }
        if(slow == 1) return true;
        return false;
    }
    public int calculate(int n){
        int result = 0;
        while(n != 0) {
            int a = n%10;
            result = result + a * a;
            n = n/10;
        }
        return result;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        System.out.println(sol.isHappy(82));
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
