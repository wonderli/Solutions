import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
                return res;
            } else {
                return Collections.emptyList();
            }
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int a = nums[i];
                int b = nums[j];
                int cd = target - a - b;
                int m = j + 1;
                int n = nums.length - 1;

                while (m < n) {
                    if (nums[m] + nums[n] == cd) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(a);
                        curr.add(b);
                        curr.add(nums[m]);
                        curr.add(nums[n]);
                        res.add(curr);
                        m++;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                        n--;
                        while (n > m && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else if (nums[m] + nums[n] < cd) {
                        m++;
                    } else if (nums[m] + nums[n] > cd) {
                        n--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {-1, 0, 1, 2, -1, -4};
        int target = -1;
        System.out.println(sol.fourSum(a, target));
    }

}
