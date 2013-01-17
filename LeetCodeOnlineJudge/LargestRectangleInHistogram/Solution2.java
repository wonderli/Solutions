//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
//For example,
//Given height = [2,1,5,6,2,3],
//return 10. 
public class Solution2{
    public int largestRectangleArea(int[] height) {
        if(height.length == 1) return height[0];
        int len = height.length;
        int min[][] = new int[len][len];
        for(int i = 0; i < len; i++){
            min[i][i] = height[i];
        }
        for(int i = 0; i< len - 1; i++){
            min[i][i+1] = Math.min(height[i], height[i+1]);
        }
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                min[i][j] = Math.min(min[i][j-1], height[j]);
            }
        }
        int max = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int curr = (j - i + 1) * min[i][j];
                if(curr > max){
                    max = curr;
                }
            }
        }
        return max;
    }
    public static void main(String args[]){
        Solution2 s = new Solution2();
        int height[] = {2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(height));
    }
}
