import java.util.*;
public class Solution4{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int k = (m+n)/2;
        int i = 0; 
        int j = k;
        int low = 0;
        int high = Math.max(k, m);
        while(true){
            i = low + (high - low)/2;
            j = k - i;
            if(get(nums1, i) >= get(nums2,j-1)){
                if(get(nums2, j) >= get(nums1, i-1)) break;
                else high = i - 1;
            }
            else low = i +1;
        }
        if((m+n)%2 == 1) return Math.min(get(nums1, i), get(nums2,j));
        return (double)(Math.min(get(nums1, i), get(nums2,j)) + Math.max(get(nums1, i-1), get(nums2, j-1)))/2;
    }
    private int get(int[] nums, int i){
        if(i < 0) return Integer.MIN_VALUE;
        if(i >= nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
    }
}
