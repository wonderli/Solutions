//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
//For example,
//Given height = [2,1,5,6,2,3],
//return 10. 
public class Solution3{
    public int largestRectangleArea(int[] height) {
        if(height.length == 0) return 0;
        //if(height.length == 1) return height[0];
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 0;
        right[n-1] = n-1;
        for(int i = 1; i < n; i++){
            //left 意思应该是从当前位置开始的左侧最大值
            left[i] = i;
            while(left[i] > 0 && height[left[i] - 1] >= height[i]){
                left[i] = left[left[i] - 1];
            }
        }
        for(int i = n - 2; i >= 0; i--){
            right[i] = i;
            while(right[i] < n - 1 && height[right[i] + 1] >= height[i]){
                right[i] = right[right[i] + 1];
            }
        }
        int ans = 0;
        for(int i = 0; i <n; i++){
            int sum = (right[i] - left[i] + 1) * height[i];
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Solution3 s = new Solution3();
        int height[] = {2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(height));
    }
}
