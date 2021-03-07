import java.util.*;
class Solution{
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int l = 0;
        int r = len - 1;
        while(l < r){
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
    private void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print("" + arr[i][j] + (j == arr[i].length - 1 ? "\n" : ", "));
            }
        }
        System.out.println();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(arr));
    }
}
