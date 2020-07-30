import java.util.*;
public class Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j <= nums.length - 2; j++){
                if(j > i+1 && nums[j] == nums[j - 1]) continue;
                int a = nums[i];
                int b = nums[j];
                int target = 0 - a - b;
                int m = j + 1;
                int n = nums.length - 1;
                while(m <= n){
                    int mid = m + (n - m)/2;
                    if(nums[mid] > target){
                        n = mid - 1;
                    }else if(nums[mid] < target){
                        m = mid + 1;
                    }else{
                        res.add(Arrays.asList(a, b, nums[mid]));
                        break;
                    }
                }


            }
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum(nums));
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
