import java.util.*;
public class Solution2{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        helper(nums, new ArrayList<>(), res, visited);
        return res;
    }
    public void helper(int[] nums, List<Integer> curr, List<List<Integer>> res, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                curr.add(nums[i]);
                helper(nums, curr, res, visited);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }


    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
