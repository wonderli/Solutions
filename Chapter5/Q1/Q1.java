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
	public static void main(String[] args){
		Q1 q = new Q1();
		q.N = new String("10000000000");
        q.M = new String("10011");
        String s = q.insert(q.N, q.M, 2, 5);
        //String new_s = new String("10001001100");
        String new_s = new String("10000001100");
        
        System.out.println("M: " + Integer.parseInt(q.M, 2));
        System.out.println("N: " + Integer.parseInt(q.N, 2));
        System.out.println("We should have: " + Integer.parseInt(new_s, 2));
        System.out.println(Integer.parseInt(s, 2));
//        CareerBitOp c = new CareerBitOp();
//        String x = new String("1000");
//        System.out.println("Test");
//        System.out.println(Integer.parseInt(x, 2));
//        int a = 0;
//        a = c.updateBit(Integer.parseInt(x,2), 1, 1);
//        System.out.println(Integer.toString(a, 2));
//        a = c.updateBit(a, 1, 0);
//        System.out.println(Integer.toString(a, 2));

	}

}

