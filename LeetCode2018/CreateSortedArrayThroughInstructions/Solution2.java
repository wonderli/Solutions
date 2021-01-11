class Solution {
    int m = (int)1e5 + 1;
    int mod = (int)1e9 + 7;
    public int createSortedArray(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] bit = new int[m];
        for(int i = 0; i < n; i++){
            int low = query(bit, arr[i] - 1);
            int high = i - query(bit, arr[i]);
            res = (res + Math.min(low, high))%mod;
            update(bit, arr[i]);
        }
        return res;
    }
    private void update(int[] bit, int x){
        while(x < m){
            bit[x]++;
            x += (x & -x);
        }
    }
    private int query(int[] bit, int x){
        int res = 0;
        while(x > 0){
            res += bit[x];
            x -= (x & -x);
        }
        return res;
    }
}