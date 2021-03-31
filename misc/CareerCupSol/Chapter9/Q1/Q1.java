//Chapter 9 Question 1
import java.io.*;
import java.util.*;
public class Q1{
    public static int f(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        return f(n-1) + f(n-2) + f(n-3);
    }
    /*
     * The following solution is mor efficiency, however I use int number, it might cause the num overflow...
     */
    public static int f(int n, HashMap<Integer, Integer> map) {
        if(map.containsKey(n))
            return map.get(n).intValue();
        int result = 0;
        if(n < 0) return 0;
        if(n == 0) result = 1;
        else{
            result = f(n-1, map) + f(n-2, map) + f(n-3, map);
        }
        map.put(n, result);
        return result;

    }
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(true) {
            try{
                System.out.println("Please input an number: ");
                String s = br.readLine();
                int n = Integer.parseInt(s);
                //System.out.println("The number inputed: " + n);
                //System.out.println("Should have the following solutions: " + f(n) + " (Use method1)");
                System.out.println("Should have the following solutions: " + f(n, map) + " (Use method2)");
            } catch(IOException e) {
                System.err.println("Input error");
            }
        }
    }
}
