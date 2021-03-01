class Solution2 {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        int c = a ^ b;
        if((a & b) != 0){
            int d = (a& b) << 1;
            return getSum(d,c);
        }
        return c;
    }
}