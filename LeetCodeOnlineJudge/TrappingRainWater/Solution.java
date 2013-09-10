// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
public class Solution{
    public int trap(int[] A) {
        int len = A.length;
        if(len <= 2) return 0;
        int leftMostHeight[] = new int[len];
        int rightMostHeight[] = new int[len];
        leftMostHeight[0] = 0;
        rightMostHeight[len-1] = 0;
        int leftMax = A[0];
        int rightMax = A[len - 1];
        for(int i = 1; i < len; i++){
            leftMostHeight[i] = leftMax;
            if(leftMax < A[i]){
                leftMax = A[i];
            }
        }
        for(int i = len-2; i >= 0; i--){
            rightMostHeight[i] = rightMax;
            if(rightMax < A[i]){
                rightMax = A[i];
            }
        }
        int ret = 0;
        for(int i = 0; i < len; i++){
            if(Math.min(leftMostHeight[i], rightMostHeight[i]) > A[i]){
                ret += Math.min(leftMostHeight[i], rightMostHeight[i]) - A[i];
            }
        }
        return ret;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {0, 1, 0, 2, 1, 0, 1, 3 ,2 ,1 ,2, 1};
        System.out.println(sol.trap(A));
    }
}
