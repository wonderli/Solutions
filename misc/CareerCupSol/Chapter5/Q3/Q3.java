class Q3 {
	public static int getNext(int n){
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while(((c & 1) == 0) && (c != 0)){
			c0++;
			c >>= 1;
		}
		while((c & 1) == 1){
			c1++;
			c >>= 1;
		}
        if(c0+c1 == 31 || c0+c1 == 0){
            return -1;
        }
        int p = c0 + c1;
        n |= (1<<p);//flip rightmost non-traling zero
        n &= ~((1<<p) - 1);//Clear all bits to the right of p
        n |= (1<<(c1 - 1)) - 1;//insert c1-1 ones to the right of p
        return n;

	}
	public static int getPrev(int n){
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while((c & 1) == 1 && (c != 0)){
            c1++; 
            c >>= 1;
        }
        if(c == 0)
            return -1;
        while((c & 1) == 0 && (c != 0)){
            c0++;
            c >>= 1;
        }
        int p = c0 + c1;
        n &= ((~0) << (p + 1));//flip non-trailing one to zero
        int mask = (1<<(c1 + 1) -1);
        n |= mask << (c0 - 1);
        return n;
	}
	public static void main(String[] args) {
        int n = 8;

        System.out.println(getNext(n));
        System.out.println(getPrev(n));
	}
}
