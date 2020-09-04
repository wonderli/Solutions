import java.util.*;
public class Solution3{
    public int findDuplicate(int[] nums){
        int i = 0;
        while(i < nums.length){
            if(nums[nums[i] - 1] == nums[i]){
                i++;
            }else{
                swap(nums, i, nums[i] -1);
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1){
                return nums[j];
            }
        }
        return -1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
        int[] nums = {1, 3, 4, 2, 2};
        sol.findDuplicate(nums);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
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
