class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int target = n - k;
        while(i < j){
            int count = select(nums, i, j);
            if(count == target){
                break;
            }else if(count < target){
                i = count + 1;
            }else{
                j = count - 1;
            }
        }
        
        return nums[target];
    }
    private int select(int[] nums, int l, int r){
        int i = l-1;
        Random rand = new Random();
        swap(nums, r, l + rand.nextInt(r -l));
        int pivot = nums[r];
        for(int j = l; j < r; j++){
            if(nums[j] < pivot){
                swap(nums, i+1, j);
                i++;
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}