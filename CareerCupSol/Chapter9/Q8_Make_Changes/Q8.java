import java.util.*;
public class Q8{
    public static int p(int n, int m) {
        int ways = 0;
        int next = 0;
        switch(m){
            case 25:
                next = 10;
                break;
            case 10:
                next = 5;
                break;
            case 5:
                next = 1;
                break;
            case 1:
                return 1;
        }
        for(int i = 0; i * m <= n; i++) {
            ways += p(n - i * m, next);
        }
        return ways;
    }
    public static void main(String args[]){
        int n = 10;
        System.out.println(p(n, 25));

    }
}
