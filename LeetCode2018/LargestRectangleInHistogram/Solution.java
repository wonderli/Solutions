import java.util.*;
public class Solution{
        public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;
        int height = 0;
        for(int i = 0; i <= n; i++){
            if(i == n){
                height = 0;
            }else{
                height = heights[i];
            }
            if(stack.isEmpty() || height >= heights[stack.peek()]){
                stack.push(i);
            }else{
                int heightIndex = stack.pop();
                int width = 0;
                if(stack.isEmpty()){
                    width = i;
                }else {
                    width = i - 1 - stack.peek();
                }
                max = Math.max(max, heights[heightIndex] * width);
                i--;
            }
        }
        return max;
    }

}
