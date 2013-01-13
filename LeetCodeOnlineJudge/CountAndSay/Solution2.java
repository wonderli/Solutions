//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//
public class Solution2{
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
        char repeat = s.charAt(0);
        s = s.substring(1);
        char sArray[] = s.toCharArray();
        int times = 1;
        for(char c : sArray){
            if(c != repeat){
                sb.append(times);
                sb.append(repeat);
                times = 1;
                repeat = c;
            }else{
                times++;
            }
        }
        sb.append(times);
        sb.append(repeat);
        return sb.toString();
    }
    public static void main(String args[]){
        int num = 3;
        Solution2 s = new Solution2();
        System.out.println(s.countAndSay(num));
    }

}
