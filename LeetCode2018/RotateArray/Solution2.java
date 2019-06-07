import java.util.*;
public class Solution2{
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len);
        reverse(nums, 0, k);
        reverse(nums, k, len);
    }
    public void reverse(int[] nums, int start, int end){
        int i = start;
        int j = end - 1;
        while(i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        sol.rotate(arr, k);
        System.out.println(Arrays.toString(arr));
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
