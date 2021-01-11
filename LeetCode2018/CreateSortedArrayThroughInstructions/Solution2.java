class Solution {
    int[] tree;
    int mod = (int)1e9 + 7;
    int m = (int)1e5 + 1;
    public int createSortedArray(int[] instructions) {
        tree = new int[m];
        int res = 0;
        int n = instructions.length;
        for(int i = 0; i < n; i++){
            res = (res + Math.min(get(instructions[i] -1), i - get(instructions[i])))%mod;
            update(instructions[i]);
        }
        return res;
    }
    private void update(int x){
        while(x < m){
            tree[x]++;
            x += x & -x;
        }
    }
    private int get(int x){
        int res = 0;
        while(x > 0){
            res += tree[x];
            x -= x & -x;
        }
        return res;
    }
}