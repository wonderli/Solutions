import java.util.*;
public class Solution2{
    public int maxArea(int[] height) {
        int left = 0;
        int right= height.length - 1;
        int max = Integer.MIN_VALUE;
        while(left < right){
            int l = height[left];
            int r = height[right];
            int area = (right - left) * Math.min(l, r);
            max = Math.max(max, area);
            if(l < r){
                left++;
            }else{
                right --;
            }
        }
        return max;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(a));
    }
}
