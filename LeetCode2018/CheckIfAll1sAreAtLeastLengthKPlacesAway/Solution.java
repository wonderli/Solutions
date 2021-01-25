public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int i = -1;
        int j = 0;
        while(j < n){
            while(j < n && nums[j] != 1){
                j++;
            }
            if(i != -1 && j != n){
                int dist = j - i - 1;
                if(dist < k){
                    return false;
                }
            }
            i = j;
            j++;
        }
        return true;
    }
     public static void main(String[] args) {
         Solution sol = new Solution();
         int[] a = {1,0,0,0,1,0,0,1,0};
         int k = 2;
         sol.kLengthApart(a, k);
      }
}