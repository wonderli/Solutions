//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//
public class Solution{
    public String countAndSay(int n) {
        if(n == 0) return Integer.toString(n);
        int time = 1;
        String ret = Integer.toString(1);
        while(time < n){
           ret = f(ret); 
           time++;
        }
        return ret.toString();
    }
    public String f(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; ){
            int repeat = 1;
            sb.append(s.charAt(i));
            while( i > 0 && s.charAt(i) == s.charAt(i - 1)){
                repeat++;
                i--;
            }
            sb.append(repeat);
            i--;
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]){
        int num = 2;
        Solution s = new Solution();
        System.out.println(s.countAndSay(num));
    }

}
