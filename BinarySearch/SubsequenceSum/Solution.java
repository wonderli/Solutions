import java.util.*;

/**

Given a list of integers nums, select a subsequence of strictly increasing numbers, where the differences of each two numbers is the same as the differences of their two indexes.

Return the maximum sum of such a subsequence.

Constraints

n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [5, 6, 8, 8, 7, 4]
Output
19
Explanation
We pick the subsequence [5, 6, 8] which has the indexes [0, 1, 3]. The differences between each consecutive numbers is [1, 2] which is the same as the differences of their indexes.


*/
class Solution {

    public int solve(int[] nums) {
        int max = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int a = nums[i] - i;
            int sum = map.getOrDefault(a, 0) + nums[i];
            map.put(a, sum);
            max = Math.max(max, sum);
        }
        return max;

    }
}
