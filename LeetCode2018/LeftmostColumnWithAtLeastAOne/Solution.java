import java.util.*;
public class Solution{
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
         if(binaryMatrix == null) return -1;
         List<Integer> dimension = binaryMatrix.dimensions();
         int row = dimension.get(0);
         int col = dimension.get(1);
         int i = 0;
         int j = col - 1;
         while(i < row && j >= 0){
             if(binaryMatrix.get(i, j) == 0){
                 i++;
             }else if(binaryMatrix.get(i, j) == 1){
                 j--;
             }
         }
         return (j == col - 1) ? -1 : j+1;
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

interface BinaryMatrix {
    public int get(int row, int col);
    public List<Integer> dimensions();
};
