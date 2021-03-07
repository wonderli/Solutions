import java.util.*;
public class Solution2{
    public List<String> letterCasePermutation(String S) {
        int binary = 0;
        for(char c : S.toCharArray()){
            if(Character.isLetter(c)){
                binary++;
            }
        }
        List<String> res = new ArrayList<>();
        for(int bits = 0; bits < 1 << binary; bits++){
            int b = 0;
            StringBuilder sb = new StringBuilder();
            for(char c : S.toCharArray()){
                if(Character.isLetter(c)){
                    if(((bits >> b++) & 1) == 1){
                        sb.append(Character.toLowerCase(c));
                    }else {
                        sb.append(Character.toUpperCase(c));
                    }
                }else{
                    sb.append(c);
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
