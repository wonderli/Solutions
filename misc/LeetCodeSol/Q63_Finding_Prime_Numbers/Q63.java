import java.util.*;
public class Q63{
    public static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public static boolean[] generatePrimeTable(int n){
        boolean prime[] = new boolean[n + 1];
        prime[0] = false;
        prime[1] = false;
        int i = 0;
        for(i = 2; i <= n; i++) {
            prime[i] = true;
        }
        for(i = 2; i < Math.sqrt(n); i++) {
            if(prime[i]) {
                for(int j = i*i; j <= n; j+=i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
    public static ArrayList<Integer> findPrimeNumByTable(int n){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        boolean prime[] = generatePrimeTable(n);
        for(int i = 2; i < n; i++){
            if(prime[i] == true) ret.add(i);
        }
        return ret;
    }

    public static ArrayList<Integer> findPrimeNum(int n){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 2; i < n; i++){
            if(isPrime(i) == true) ret.add(i);
        }
        return ret;
    }
    public static void main(String args[]){
        int n  = 152;
        //ArrayList<Integer> ret = findPrimeNum(n);
        ArrayList<Integer> ret = findPrimeNumByTable(n);
        for(Integer e : ret){
            System.out.print(e.intValue() + " ");
        }
        System.out.println();
    }
}
