import java.util.*;
/**

Given a list of integers nums, and an integer k, find k sublists with the largest sums and return the sums in ascending order.

Constraints

n ≤ 1,000 where n is length of nums
k ≤ 100
Example 1
Input
nums = [1, 3, 4, -100, 10, -30, 5, -3, 5]
k = 3
Output
[7, 8, 10]
Explanation
We have these 3 sublists with the largest sums: [5, -3, 5], [1, 3, 4], [10].

Example 2
Input
nums = [10, 11]
k = 2
Output
[11, 21]

*/
class Solution {
    public int[] solve(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] prefix = new int[n+1];
        for(int i = 1; i <= nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < i; j++){
                pq.add(prefix[i] - prefix[j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;

    }
}