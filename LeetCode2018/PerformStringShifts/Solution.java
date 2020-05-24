import java.util.*;
public class Solution{
    public String stringShift(String s, int[][] shift) {
        if(s == null) return null;
        int[] result = process(shift);
        int len = s.length();
        result[1] = result[1] % len;
        System.out.println(Arrays.toString(result));
        String res = shift(s, result);
        return res;
    }

    private String shift(String s, int[] result){
        int dir = result[0];
        int pos = result[1];
        int p = 0;
        if(dir == 0){
            p = pos;
        }else {
            p = s.length() - pos;
        }
        char[] str = s.toCharArray();
        reverse(str, 0, p-1);
        reverse(str, p, str.length - 1);
        reverse(str, 0, str.length - 1);
        return new String(str);
    }
    public void reverse(char[] s, int start, int end){
        while(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    private int[] process(int[][] shift){
        int[] result = new int[2];
        result[0] = shift[0][0];
        result[1] = shift[0][1];
        for(int i = 1; i < shift.length; i++){
            int dir = shift[i][0];
            int pos = shift[i][1];
            int prevDir = result[0];
            int prevPos = result[1];
            if(dir == prevDir){
                result[1] = (prevPos + pos);
                result[0] = dir;
            }else {
                result[1] = Math.abs(pos - prevPos);
                result[0] = pos > prevPos ? dir : prevDir;
            }
        }
        return result;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[][] shift = {{0, 1}, {1, 2}};
        String a = "abc";
        sol.stringShift(a, shift);
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
