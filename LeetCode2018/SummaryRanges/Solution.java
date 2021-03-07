import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        int i = 0;
        int j = 1;
        int len = nums.length;
        while (i < len && j < len) {
            if (nums[j] == nums[j - 1] + 1) {
                j++;
            } else {
                String s = get(nums, i, j - 1);
                res.add(s);
                i = j;
                j++;
            }
        }
        String s = get(nums, i, nums.length-1);
        res.add(s);
        return res;
    }

    private String get(int[] nums, int start, int end) {
        if (end > nums.length || start == end) {
            return Integer.toString(nums[start]);
        }
        return String.format("%d->%d", nums[start], nums[end]);
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        int[] a = {0, 1, 2, 4, 5, 7, 8, 11, 13, 15, 17, 19};
        System.out.println(sol.summaryRanges(a));
    }
}
