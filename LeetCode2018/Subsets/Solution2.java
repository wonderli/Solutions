import java.util.*;
public class Solution2{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }

        helper(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(curr));

            return;
        }
        if(index < nums.length){
            res.add(new ArrayList<>(curr));
        }

        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            helper(i+1, nums, curr, res);
            curr.remove(curr.size() - 1);   
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
