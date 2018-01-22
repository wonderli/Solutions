import java.util.*;
public class Solution{
    public String[] createData(String s, int numRows){
        String[] sl = new String[numRows];
        for(int i = 0; i < numRows; i++){
            sl[i] = new String();
        }
        int len = s.length();
        int level = 0;
        boolean flag = true;
        for(int i = 0; i < len; i++){
            sl[level] = sl[level] + s.charAt(i);
            if(flag){
                level++;
            }else{
                level--;
            }
            if(level == numRows) {
                level = level - 2;
                flag = !flag;
            }else if(level < 0){
                level = level + 2;
                flag = !flag;
            }
        }
        return sl;
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        String[] sl = createData(s, numRows);
        for(int i = 0;i < numRows;i++){
            sb.append(sl[i]);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "PAYPALISHIRING";
        s = "ABC";
        System.out.println(sol.convert(s, 2));

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
