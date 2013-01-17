// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
public class Solution{
    public int maxSubArray(int[] A) {
        if(A == null) return 0;
        int len = A.length;
        int max = 0;
        boolean isNeg = false;
        for(int i = 0; i < len; i++){
            if(A[i] >= 0){
                isNeg = true;
                break;
            }
        }
        if(isNeg == false){
            max = A[0];
            for(int i = 1; i < len; i++){
                if(A[i] > max){
                    max = A[i];
                }
            }
            return max;
        }
        int curr = 0;
        for(int i = 0; i < len; i++){
            curr += A[i];
            if(curr < 0){
                curr = 0;
            }
            if(curr > max){
                max = curr;
            }
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray(A));
    }
}
