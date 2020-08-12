import java.util.*;
public class Solution{
    public int findNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(isEven(nums[i])){
                count++;
            }
        }
        return count;
    }
    public boolean isEven(int num){
        int count = 0;
        while(num != 0){
            num = num/10;
            count++;
        }
        return count%2 == 0;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
