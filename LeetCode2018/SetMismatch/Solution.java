

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return new int[]{i, nums[i]};
            }
        }
        return null;
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
     public static void main(String[] args) {
         Solution sol = new Solution();
         int[] a = {4, 3, 2, 1};
         sol.findErrorNums(a);
      }

}