class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer a = null;
        Integer b = null;
        Integer c = null;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(a == null || nums[i] <= nums[a]){
                a = i;
            }else if(b == null || (nums[i] > nums[a] && nums[i] <= nums[b])){
                b = i;
            }else if(c == null || nums[i] > nums[b] && nums[i] > nums[c]){
                c = i;
            }
        }
        return a != null && b != null && c != null;
    }
     public static void main(String[] args) {
         Solution sol = new Solution();
         int[] a = {1,1, 1, 1, 1};
         sol.increasingTriplet(a);
      }
}