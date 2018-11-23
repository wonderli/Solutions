import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("-9128"));
        System.out.println(sol.myAtoi("-91283472332"));
        System.out.println(sol.myAtoi("-+1283472332"));
        System.out.println(sol.myAtoi("-1283472332"));
        System.out.println(sol.myAtoi("-+12+"));
        System.out.println(sol.myAtoi("18446744073709551617"));
    }

    private int findFirstNonWhiteSpace(final String s) {
        int len = s.length();
        int j = -1;
        for(int i = 0; i < len;i++){
            if(s.charAt(i) != ' '){
                j = i;
                break;
            }
        }
        if(j == -1) return -1;
        return j;
    }
    private boolean notSignOrNumber(char c){
        return !(c == '+' || c == '-' || isNumber(c));
    }
    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    private int findLastNumber(String s){
        int len = s.length();
        if(len == 0) return 0;
        if(notSignOrNumber(s.charAt(0))){
            return 0;
        }
        int i = 1;
        while(i < len){
            if(!isNumber(s.charAt(i))){
                break;
            }
            i++;
        }
        return i;
    }
//    private int round(long result, boolean isNegative){
//        long max = Integer.MAX_VALUE;
//        long min = Integer.MIN_VALUE;
//
//        if(!isNegative){
//            return (result - max) > 0 ? Integer.MAX_VALUE : (int)result;
//        }else {
//			return (result - min) < 0 ? Integer.MIN_VALUE : (int)result;
//        }
//    }
    public int parse(String s){
        int len = s.length();
        boolean isPositive = s.charAt(0) != '-';
        int start = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        long result = 0;
        boolean isNegative = start==1 && s.charAt(0) == '-';
        for(int i = start; i < len; i++){
            if(!isNumber(s.charAt(i))) return 0;
            result = result * 10 + s.charAt(i) - '0';
            if(result - Integer.MAX_VALUE > 0) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        if(isNegative){
            result = -1 * result;
        }
        //int ret = round(result, isNegative);
        return (int)result;
    }
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int start = findFirstNonWhiteSpace(str);
        if(start == -1) return 0;
        String s1= str.substring(start);
        if(s1.length() == 0 || s1.equals("")) return 0;
        if(notSignOrNumber(s1.charAt(0))){
            return 0;
        }
        int end = findLastNumber(s1);
        String s2 = s1.substring(0, end);
        if(s2.length() == 0 || s2.equals("")) return 0;
        int parseResult = parse(s2);
        return parseResult;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
