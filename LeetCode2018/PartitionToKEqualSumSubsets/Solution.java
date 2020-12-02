class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return false;
        int sum = 0;
        for(int e : nums){
            sum += e;
        }
        if(sum %k != 0) return false;
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        return dfs(nums, n-1, visited, k, sum/k, 0);
    }
    private boolean dfs(int[] nums, int start, boolean[] visited, int k, int target, int sum){
        if(k == 0) return true;
        if(sum == target){
            return dfs(nums, nums.length - 1, visited, k-1, target, 0);
        }
        for(int i = start; i >= 0; i--){
            if(!visited[i] && nums[i] + sum <= target){
                visited[i] = true;
                if(dfs(nums, i-1, visited, k, target, nums[i] + sum)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}