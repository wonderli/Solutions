import java.util.*;
import java.util.stream.Collectors;
public class Solution{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, curr, res, 0);
        return res;
    }
    public void helper(int[] nums, List<Integer> curr, List<List<Integer>> res, int index){
        if(index == nums.length){
            res.add(curr);
            return;
        }
        for(int i = index; i < nums.length; i++){
            List<Integer> c = new ArrayList<>(curr);
            curr.add(nums[i]);
            helper(nums, curr, res, i+1);
            curr = c;
        }

        helper(nums, curr, res, nums.length);
    }


    public static void main(String args[]){
        Solution sol = new Solution();
        int[] n = {1,2,3};
        List<List<Integer>> res = sol.subsets(n);
        for(List<Integer> e : res){
            System.out.println(e);
        }

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
