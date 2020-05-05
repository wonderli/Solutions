import java.util.*;
public class Solution{
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < (n + 1)/2; i++){
            for(int j = 0; j < n/2; j++){
                int tmp = matrix[n - 1 - j][i];
                matrix[n- 1 - j][i] = matrix[n - 1 -i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
                System.out.println("==================================");
                System.out.println(String.format("i: %d, j: %d", i, j));
                System.out.println("==================================");
                print(matrix);
                System.out.println("==================================");
            }
        }
    }
    public void print(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        sol.rotate(matrix);
        sol.print(matrix);
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
