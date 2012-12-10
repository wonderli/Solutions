import java.util.*;
public class Sol{
    public static String increase(String s){
        char ar[] = new char[s.length() + 1];
        ar[0] = '0'; 
        for(int i = s.length(); i >= 1; i--){
            ar[i] = s.charAt(i - 1);
        }
        int len = ar.length;
        int i = len - 1;
        int carry = 1;
        int curr = 0;
        while(carry != 0 && i >= 1){
            curr = (int)(ar[i] - '0');
            curr += carry;
            if(curr >= 10){
                carry = curr - 9;
                curr = 0;
            }else{
                carry = 0;
            }
            ar[i] = (char)(curr + '0');
            i--;
        }
        if(carry > 0){
            curr = (int)(ar[i] - '0');
            curr += carry;
            ar[i] = (char)(curr + '0');
        }
        int start = 0;
        if(ar[0] > '0'){
            start = 0;
        }else{
            start = 1;
        }
        //System.out.println(Arrays.toString(ar));
        StringBuilder sb = new StringBuilder();
        sb.append(ar, start, ar.length - start);
        String ret = sb.toString();
        return ret;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            System.out.println(increase(str));
        }
    }
}
