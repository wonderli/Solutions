class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int i = 1;
        int count = 1;
        for(int j = 1; j < n; j++){
            if(nums[j] == nums[i-1]){
                count++;
            }else{
                count = 1;
            }
            if(count <= 2){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}