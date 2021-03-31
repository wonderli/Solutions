import java.util.*;
public class Main{
    public String myadd(String a, String b, boolean neg){
        int len1 = a.length();
        int len2 = b.length();
        if(len1 < len2){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int len = a.length();
        a = reverse(a);
        b = reverse(b);
        char s1[] = a.toCharArray();
        char s2[] = new char[len];
        for(int i = 0; i < b.length(); i++){
            s2[i] = b.charAt(i);
        }
        for(int i = b.length(); i < len; i++){
            s2[i] = '0';
        }
        char ans[] = new char[len + 1];
        int carry = 0;
        for(int i = 0; i < len; i++){
            int x = s1[i] - '0';
            int y = s2[i] - '0';
            if(x + y + carry >= 10){
                ans[i] = (char)((x + y + carry)%10 + '0'); 
                carry = (x + y + carry)/10;
            }else{
                ans[i] = (char)((x + y + carry)%10 + '0');
                carry = 0;
            }
        }
        ans[len] = (char)(carry + '0');
        String ret = new String(ans);
        ret = reverse(ret);
        if(ret.charAt(0) == '0')
            ret = ret.substring(1);
        if(neg == true){
            ret = "-" + ret;
        }
        return ret;
    }
    public String mySubstract(String a, String b){
        if(a == null || b == null) return null;
        boolean neg = false;
        int len1 = a.length();
        int len2 = b.length();
        if(a.charAt(0) == '-' && b.charAt(0) == '-'){
            a = a.substring(1);
            b = b.substring(1);
            neg = !neg;
        }else if(a.charAt(0) != '-' && b.charAt(0) == '-'){
            return myadd(a, b.substring(1), false);
        }else if(a.charAt(0) == '-' && b.charAt(0) != '-'){
            return myadd(a.substring(1), b, true);
        }
        if(len1 < len2 || ((len1 == len2) && a.compareTo(b) < 0)){
            String tmp = a;
            a = b;
            b = tmp;
            neg = !neg;
        }
        int len = a.length();
        a = reverse(a);
        b = reverse(b);
        char s1[] = a.toCharArray();
        char s2[] = new char[len];
        for(int i = 0; i < b.length(); i++){
            s2[i] = b.charAt(i);
        }
        for(int i = b.length(); i < len; i++){
            s2[i] = '0';
        }
        int carry = 0;
        char ans[] = new char[len];
        for(int i = 0; i < len; i++){
            //System.out.println("S1[i] : " + s1[i]);
            //System.out.println("S2[i] : " + s2[i]);
            if(s1[i] >= s2[i]){
                ans[i] = (char)(s1[i] - s2[i] + '0');
            }else{
                    ans[i] = (char)(s1[i] - s2[i] + '0' + 10);
                    int j = i + 1;
                    while(j < len && s1[j] == '0'){
                        s1[j] = (char)(9 + '0');
                        j++;
                    }
                    s1[j] = (char)(s1[j] - '1' + '0');
            }
        }
        String ret = new String(ans);
        ret = reverse(ret);
        int i = 0;
        while(i < ret.length() && ret.charAt(i) == '0'){
            i++;
        }
        ret = ret.substring(i);
        if(neg == true){
            ret = "-" + ret;
        }
        return ret;
    }
    public String reverse(String s){
        if(s == null) return null;
        int i = 0;
        int j = s.length() - 1;
        char str[] = s.toCharArray();
        while(i < j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return new String(str);
    }
    public static void main(String args[]){
        Main sol = new Main();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(sol.mySubstract(a,b));
    }
}
