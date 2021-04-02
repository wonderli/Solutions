import java.util.*;

class Solution {
    public int solve(int n) {
        String s = Integer.toString(n);
        int[] nums = new int[s.length()];
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]));
        for(int i = 0; i < nums.length; i++){
            nums[i] = s.charAt(i) - '0';
            pq.add(new int[]{nums[i], i});
        }
        int i = 0;
        
        while(!pq.isEmpty() && i < nums.length){
            int[] curr = pq.peek();
            if(curr[0] == nums[i]){
                if(curr[1] > i){
                    i++;
                }else{
                    pq.poll();
                }
            }else if(curr[0] > nums[i]){
                swap(nums, i, curr[1]);
                break;
            }else{
                i++;
            }
        }
        int result = 0;
        for(int k = 0; k < nums.length; k++){
            result = result * 10 + nums[k];
        }
        return result;
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
