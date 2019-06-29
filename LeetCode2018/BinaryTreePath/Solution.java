import java.util.*;
public class Solution{
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        btp(result, curr, root);
        return convert(result);
    }
    public void btp(List<List<Integer>> result, List<Integer> curr, TreeNode root){
        if(root == null) return;
        curr.add(root.val);
        if(root.left  == null && root.right == null) {
            result.add(curr);
            return;
        }
        if(root.left != null) {
            List<Integer> left = new ArrayList<>(curr);
            btp(result, left, root.left);
        }
        if(root.right != null){
            List<Integer> right = new ArrayList<>(curr);
            btp(result, right, root.right);
        }
    }
    public List<String> convert(List<List<Integer>> result){
        List<String> ret = new ArrayList<>();
        for(List<Integer> curr : result){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < curr.size(); i++){
                sb.append(curr.get(i));
                if(i != curr.size() - 1){
                    sb.append("->");
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.right = new TreeNode(5);
        System.out.println(sol.binaryTreePaths(n));
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
