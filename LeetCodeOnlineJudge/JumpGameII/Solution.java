// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// For example:
// Given array A = [2,3,1,1,4]
//
// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
public class Solution{
    public int jump(int[] A) {
        if(A == null) return 0;
        int len = A.length;
        if(len == 1) return 0;
        int jump = 0;
        int currMax = 0;
        int i = 0;
        while(i < len){
            currMax = i + A[i];
            if(currMax > 0) jump++;
            if(currMax >= len - 1) return jump;
            int tmp = 0;
            for(int j = i + 1; j <= currMax; j++){
                if(j + A[j] > tmp){
                    tmp = j + A[j];
                    i = j;
                }
            }
        }
        return jump;
    }
    public static void main(String args[]){
        //int A[] = {4, 3, 2, 1};
        int A[] = {2, 3, 1, 1, 4};
        //int A[] = {3, 2, 1};
        Solution s  = new Solution();
        System.out.println(s.jump(A));

    }
}
