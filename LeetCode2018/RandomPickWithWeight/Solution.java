class Solution {
    int[] prefixSums;
    int totalSum;
    public Solution(int[] w) {
        prefixSums = new int[w.length];
        int prefixSum = 0;
        for(int i = 0; i < w.length;i++){
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        totalSum = prefixSum;
    }
    
    public int pickIndex() {
        double target = totalSum * Math.random();
        int low = 0;
        int high = prefixSums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(target > prefixSums[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */