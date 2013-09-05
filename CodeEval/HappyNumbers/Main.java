import java.util.*;
import java.io.*;
public class Main {
    public static int squareSum(int num){
        int ret = 0;
        String s = Integer.toString(num);
        int len = s.length();
        for(int i = 0; i < len; i++){
            int curr = s.charAt(i) - '0';
            ret += (curr * curr);
        }
        return ret;
    }
    public static void solve(int num){
        if(num == 1){
            System.out.println(1);
            return;
        }
        boolean flag = false;
        int last = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while(true){
            num = squareSum(num);
            if(set.contains(num)){
                System.out.println(0);
                break;
            }else{
                if(num == 1){
                    System.out.println(1);
                    break;
                }else{
                    set.add(num);
                }
            }

        }
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                int num = Integer.parseInt(line);
                solve(num);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
