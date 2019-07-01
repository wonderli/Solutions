import java.util.*;
public class Solution2{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if(map.containsKey(remain)){
                return new int[] {map.get(remain), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum soluiton");
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
