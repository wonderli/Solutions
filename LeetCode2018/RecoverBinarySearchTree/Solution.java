import java.util.*;
public class Solution{
    List<TreeNode> result = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        TreeNode first = null;
        TreeNode second = null;
        for(int i = 0; i < result.size() -1; i++){
            if(result.get(i+1).val < result.get(i).val){
                second = result.get(i+1);
                if(first == null){
                    first = result.get(i);
                }else{
                    break;
                }
            }
        }
        int a = first.val;
        int b = second.val;
        first.val = b;
        second.val = a;

    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        result.add(root);
        inorder(root.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
