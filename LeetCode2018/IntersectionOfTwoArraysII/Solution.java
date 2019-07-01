import java.util.*;
public class Solution{
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return null;
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums2[j] < nums1[i]){
                j++;
            }else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(sol.intersect(nums1, nums2)));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
