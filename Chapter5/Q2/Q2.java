class Q2{
    public static String printBinary(double num){
        if(num > 1 || num < 0)
            return "ERROR";
        StringBuilder bin = new StringBuilder();
        bin.append(".");
        while(num > 0) {
            if(bin.length() > 32)
                return "ERROR";
            double r = num * 2;
            if(r >= 1) {
                bin.append(1);
                num = r - 1;
            }else {
                bin.append(0);
                num = r;
            }
        }
        return bin.toString();
    }
    public static void main(String[] args) {
        double num = 0.75;
        System.out.println(printBinary(num));
    }
}
