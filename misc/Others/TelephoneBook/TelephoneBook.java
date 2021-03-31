import java.util.*;
public class TelephoneBook{
    public static String telepad[] = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWXYZ"};
    public static String getCharFromTelepad(String s, int num){
        char c = s.charAt(num);
        String ret = Character.toString(c);
        return ret;
    }
    public static void parseNum(String s, String prefix, int n){
        if(n == s.length()) {
            System.out.println(prefix);
            return;
        }
        char curNum = s.charAt(n);
        int index = Character.getNumericValue(curNum);
        String currPad = telepad[index];
        String newPrefix = new String();
        int len = currPad.length();
        if(len == 0) parseNum(s, prefix, n+1);
        else{
            for(int i = 0; i < currPad.length(); i++){
                String currNumber = getCharFromTelepad(currPad, i);
                newPrefix = prefix + currNumber;
                parseNum(s, newPrefix, n+1);
            }
        }



    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num = 0;
        try{
            num = in.nextInt();
        }catch(Exception e){
            System.out.println("Input Error");
        }
        System.out.println("Input Number: " + num);
        String numString = Integer.toString(num);
        parseNum(numString, "", 0);
    }
}
