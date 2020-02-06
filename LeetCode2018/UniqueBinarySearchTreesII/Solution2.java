import java.util.*;
public class Solution2{
    public List<TreeNode> generateTrees(int n){
        if(n < 1) return new ArrayList<>();
        return helper(1, n);
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> ret = new ArrayList<>();
        if(start > end) {
            ret.add(null);
        }else if(start == end){
            ret.add(new TreeNode(start));
        }else {
            for(int i = start; i <= end; i++){
                List<TreeNode> left = helper(start, i - 1);
                List<TreeNode> right = helper(i + 1, end);
                for(TreeNode l : left){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        ret.add(root);
                    }
                }
            }
        }
        return ret;
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
