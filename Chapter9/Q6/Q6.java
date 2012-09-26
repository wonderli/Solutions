import java.util.*;
public class Q6 {
    public static Set<String> perm(int n){
        Set<String> ret = new HashSet<String>();
        if(n == 0){
            String s = new String("");
            ret.add(s);
            return ret;
        }
        for(String str : perm(n - 1)) {
            String x1 = new String("()" + str);
            String x2 = new String("(" + str + ")");
            String x3 = new String(str + "()");
            ret.add(x1);
            ret.add(x2);
            ret.add(x3);
        }
        return ret;
    }
    public static void main(String args[]) {
        int n = 3;
        System.out.println(perm(n));

    }
}
