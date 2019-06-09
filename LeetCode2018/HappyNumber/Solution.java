import java.util.*;
public class Solution{
    public boolean isHappy(int n) {
        if(n == 1) return true;
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }
    public boolean isHappy(int n, Set<Integer> set){
        int result = 0;
        while(n != 0){
            int a = n%10;
            result = result + a * a;
            n = n/10;
        }
        if(result == 1) {
            return true;
        }

        if(!set.add(result)) {
            return false;
        }
        return isHappy(result, set);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
