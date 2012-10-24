public class Q22{
    public static int totalWays(int m){
        int upper = (int)Math.sqrt((double)m/2.0);
        int total = 0;
        double epsilon = 0.0000001;
        for(int i = 0; i <= upper; i++){
            double j = Math.sqrt((double)m - (double)(i*i));
            if((j - (int)j) < epsilon){
                System.out.println(m + " = " + i + "^2 + " + j + "^2");
                total++;
            }
        }
        return total;
    }
    public static void main(String args[]){
        int num = 10000;
        System.out.println(totalWays(num));

    }
}
