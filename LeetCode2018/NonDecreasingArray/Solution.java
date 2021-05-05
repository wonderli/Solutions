class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < prev){
                if(count > 0) return false;
                count++;
                if(i - 2 >= 0 && nums[i-2] > nums[i]) continue;
            }
            prev = nums[i];
        }
        return true;
    }
     public static void main(String[] args) {
         Solution sol = new Solution();
         int[] a = {2, 4, 1, 1, 0};
         sol.checkPossibility(a);
      }
}