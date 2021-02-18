class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // int[] dp = new int[A.length];
        int sum = 0;
        int dp = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp = dp + 1;
                sum += dp;
            }else{
                dp = 0;
            }
        }
        return sum;
    }
}