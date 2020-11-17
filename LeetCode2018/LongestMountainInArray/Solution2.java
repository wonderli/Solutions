class Solution2 {
    public int longestMountain(int[] A) {
        int n = A.length;
        int res = 0;
        int i = 0;
        while(i< n){
            int j = i;
            if(j +1 < n && A[j] <A[j+1]){
                while(j+1<n && A[j] < A[j+1]) j++;
                if(j + 1 < n && A[j] > A[j+1]){
                    while(j+1 < n && A[j] > A[j+1]){
                        j++;
                    }
                    res = Math.max(res, j - i + 1);
                }
            }
            i = Math.max(j, i+1);
        }
        return res;
    }
}