import java.util.*;
public class Solution{
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowSet = new boolean[10][10];
        boolean[][] colSet = new boolean[10][10];
        boolean[][] sectionSet = new boolean[10][10];
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char v = board[r][c];
                if(v != '.'){
                    int value = v - '0';
                    if(value < 1 || value > 9) return false;

                    if(rowSet[r][value]){
                        return false;
                    }
                    rowSet[r][value] = true;

                    if(colSet[c][value]){
                        return false;
                    }
                    colSet[c][value] = true;

                    int index = (r /3) * 3 + (c/3);
                    if(sectionSet[index][value]){
                        return false;
                    }
                    sectionSet[index][value] = true;
                }
            }
        }
        return true;
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
