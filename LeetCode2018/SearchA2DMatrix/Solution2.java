import java.util.*;
public class Solution2{
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            int x = mid/n;
            int y = mid%n;
            if(matrix[x][y] < target){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        int x = l/n;
        int y = l%n;
        return matrix[x][y] == target;
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
