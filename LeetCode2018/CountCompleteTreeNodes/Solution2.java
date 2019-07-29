import java.util.*;
public class Solution2{
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int d = height(root);
        if(d == 0) return 1;
        int left = 1;
        int right = (int) Math.pow(2, d) - 1;
        int pivot;
        while(left <= right){
            pivot = left + (right - left)/2;
            if(exists(pivot, d, root)){
                left = pivot+1;
            }else {
                right = pivot - 1;
            }
        }
        return (int) Math.pow(2, d) - 1 + left;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int count = 0;
        while(root.left != null){
            root = root.left;
            count++;
        }
        return count;
    }
    public boolean exists(int idx, int d, TreeNode node){
        int left = 0;
        int right = (int) Math.pow(2, d) - 1;
        int pivot;
        for(int i = 0; i < d; i++){
            pivot = left + (right - left)/2;
            if(idx <= pivot){
                node = node.left;
                right = pivot;
            }else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
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
