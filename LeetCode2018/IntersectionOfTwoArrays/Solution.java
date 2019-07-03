import java.util.*;
public class Solution{
	public int[] intersection(int[] nums1, int[] nums2) {
	        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
	            return new int[0];
	        }
	        int len1 = nums1.length;
	        int len2 = nums2.length;
	        Set<Integer> set1 = new HashSet<>();
			Set<Integer> res = new HashSet<>();
			for(int i = 0; i < len1; i++){
				set1.add(nums1[i]);
			}
			for(int i = 0; i < len2; i++){
				if(set1.contains(nums2[i])){
					res.add(nums2[i]);
				}
			}
	        return res.stream().mapToInt(Integer::intValue).toArray();
	    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(sol.intersection(nums1, nums2)));
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
