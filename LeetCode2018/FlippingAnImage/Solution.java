class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A.length == 0 || A[0].length == 0) {
            return A;
        }
        int m = A.length;
        int n = A[0].length;
        for(int i = 0; i < m; i++){
            int l = 0;
            int r = n-1;
            while(l <= r){
                if((A[i][l] ^ A[i][r]) == 0){
                    int a = A[i][l];
                    if(a == 0){
                        a = 1;
                    }else{
                        a = 0;
                    }
                    A[i][l] = a;
                    A[i][r] = a;
                }
                l++;
                r--;
            }
        }
        return A;
    }
}