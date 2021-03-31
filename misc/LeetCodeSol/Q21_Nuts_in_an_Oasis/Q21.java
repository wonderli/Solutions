public class Q21{
    // N Nuts
    // C carry
    // D O to T distance
    // F cousume per km
    public static double f(double N, double D, double F, double C){
        if(N <= C){
            double remain = N - D * F;
            return (remain >= 0.0) ? remain :0.0;
        }
        int NumTrips = (int)(2 * (Math.ceil(N/C) - 1) + 1);
        double RemainNuts = C * (Math.ceil(N/C) - 1);
        double travelLen = (N - RemainNuts)/(NumTrips * F);
        if(travelLen >= D) return N - D*NumTrips*F;
        return f(RemainNuts, D - travelLen, C, F );
    }

    public static void main(String args[]){
        int N = 100;
        int D = 20;
        int C = 50;
        int F = 1;
        System.out.println(f(N, D, C, F));
    }
}
