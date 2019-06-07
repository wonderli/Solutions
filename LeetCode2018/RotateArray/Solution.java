import java.util.*;
public class Solution{
    public void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if(k > len) { k = k%len;}
        for(int i = len - k; i < len; i++){
            list.add(nums[i]);
        }
        for(int j = 0; j < len - k; j++){
            list.add(nums[j]);
        }
        for(int i = 0; i < len; i++){
            nums[i] = list.get(i);
        }

    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
