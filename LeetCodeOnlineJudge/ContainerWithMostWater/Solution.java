//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
public class Solution{
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while(i < j){
            int width = j - i;
            int current = width * ((height[i] > height[j])? height[j]:height[i]);
            if(height[i] < height[j]){
                i++;
            }else if(height[j] < height[i]){
                j--;
            }else{
                i++;
                j--;
            }
            if(current > max){
                max = current;
            }
        }
        return max;
    }
    public static void main(String args[]){

    }
}
