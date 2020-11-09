class Solution2 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int max = -1;
        int l = 0;
        int r = A.length -1;
        while(l < r){
            if(A[l] +A[r] < K){
                max = Math.max(max, A[l] + A[r]);
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}