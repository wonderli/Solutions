import java.util.*;
public class Solution{
    public int[] diStringMatch(String s) {
        if(s == null || s.length() == 0) return new int[0];
        int len = s.length();
        int[] num = new int[len+1];
        for(int i = 0; i < len+1; i++){
            num[i] = i;
        }
        int numD = 0;
        int numI = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == 'D'){
                numD++;
            }else if(s.charAt(i) == 'I'){
                numI++;
            }
        }
        int dValue = len;
        int iValue = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == 'D'){
                num[i] = dValue;
                dValue--;
            }else if(s.charAt(i) == 'I'){
                num[i] = iValue;
                iValue++;
            }
        }
        if(s.charAt(len-1) =='D'){
            num[len] = iValue;
        }else if(s.charAt(len-1) == 'I'){
            num[len] = dValue;
        }
        return num;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int[] num = sol.diStringMatch("IDID");
        int[] num = sol.diStringMatch("IIID");
        System.out.println(Arrays.toString(num));
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
