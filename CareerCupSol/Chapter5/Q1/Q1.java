class Q1{
	String M;
	String N;
	public String insert(String N, String M, int j, int k){
        CareerBitOp c = new CareerBitOp();
        int n = Integer.parseInt(N, 2);
        int m = Integer.parseInt(M, 2);
        for(int i = j; i <= k; i++) {
            if(c.getBit(m, i - j))
                n = c.updateBit(n, i, 1);
            else
                n = c.updateBit(n, i, 0);
        }
        String ret = Integer.toString(n, 2);
		return ret;
	}
    public int CareerInsert(int n, int m, int i, int j){
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = ~(allOnes << i);
        int mask = left | right;
        int clear = n & mask;
        int ret = clear | m << i;
        return ret;
    }
	public static void main(String[] args){
		Q1 q = new Q1();
		q.N = new String("10000000000");
        q.M = new String("10011");
        String s = q.insert(q.N, q.M, 2, 6);
        String new_s = new String("10001001100");
       //String new_s = new String("10000001100");
        
        System.out.println("M: " + Integer.parseInt(q.M, 2));
        System.out.println("N: " + Integer.parseInt(q.N, 2));
        System.out.println("We should have: " + new_s);
        System.out.println("From Xinyu Solution you have: " + s);
        System.out.println("The following is CareerCup Solution ");
        int x = Integer.parseInt(q.N, 2);
        int y = Integer.parseInt(q.M, 2);
        int z = q.CareerInsert(x, y, 2, 5);
        System.out.println(Integer.toString(z, 2));

	}

}

