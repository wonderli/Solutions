import java.util.*;
public class Solution{
    public List<List<String>> solveNQueens(int n) {
        int[] list = new int[n];

        List<List<String>> ret = new ArrayList<>();
        helper(list, 0, ret);
        return ret;
    }
    public void helper(int[] list, int col, List<List<String>> ret){
        if(col == list.length){
            ret.add(convert(list));
            return;
        }
        for(int r = 0; r < list.length; r++){
            if(check(r, col, list)){
                list[col] = r;
                helper(list, col + 1, ret);
            }
        }
    }
    public boolean check(int row, int col, int list[]){
        for(int c = 0; c < col; c++){
            int r = list[c];
            if(r == row) return false;
            if(r - c == row - col || r + c == row + col){
                return false;
            }
        }
        return true;
    }
    public List<String> convert(int[] list){
        int len = list.length;
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < len; j++){
                if(j == list[i]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
