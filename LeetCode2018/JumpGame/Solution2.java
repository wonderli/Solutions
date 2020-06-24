import java.util.*;
public class Solution2{
    enum Index {
        Good, Bad, Unknown
    }
    public boolean canJump(int[] nums){
        Index[] memo = new Index[nums.length];
        for(int i = 0; i < nums.length; i++){
            memo[i] = Index.Unknown;
        }

        memo[nums.length - 1] = Index.Good;
        for(int i = nums.length - 2; i>= 0; i--){
            int maxJump = Math.min(i + nums[i], nums.length - 1);
            for(int j = i + 1; j <= maxJump; j++){
                if(memo[j] == Index.Good){
                    memo[i] = Index.Good;
                    break;
                }
            }
        }
        return memo[0] == Index.Good;
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
