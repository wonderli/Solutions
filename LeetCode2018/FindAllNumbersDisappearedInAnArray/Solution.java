import java.util.*;
public class Solution{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while(j < nums.length && i < nums.length){
            if(nums[i] != i + 1){
                swap(nums, i, nums[i] - 1); 
            }
            if(nums[i] == nums[nums[i] - 1]){
                j++;
                i = j;
            }
        }
        for(int m = 0; m < nums.length; m++){
            if(nums[m] != m +1){
                ret.add(m+1);
            }
        }
        System.out.println(Arrays.toString(nums));

        return ret;
    }
    public void swap(int A[], int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {4,3,2,7,8,2,3,1};
        //int A[] = {1, 1, 2, 4};
        System.out.println(sol.findDisappearedNumbers(A));
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
