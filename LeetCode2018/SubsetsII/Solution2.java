import java.util.*;
public class Solution2{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>(), res);
        return res;
    }
    public void helper(int index,int[] nums, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            List<Integer> tmp = new ArrayList<>(curr);
            curr.add(nums[i]);
            helper(i+1, nums, curr, res); 
            curr = tmp;
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] nums = {1, 2, 2};
        System.out.println(sol.subsetsWithDup(nums));
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
