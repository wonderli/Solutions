import java.util.*;
public class Solution{

    public int sumRootToLeaf(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, new ArrayList<>());
        return sum(list);
    }
    public int sum(List<List<Integer>> list){
        int sum = 0;
        for(List<Integer> e : list){
            int curr = 0;
            for(Integer v : e){
                curr = curr << 1 | v ;
            }
            sum += curr;
        }
        return sum;
    }
    public void dfs(TreeNode root, List<List<Integer>> list, List<Integer> curr){
        if(root == null) {
            return;
        }
        curr.add(root.val);
        if(root.left == null && root.right == null){
            list.add(curr);
        }
        dfs(root.left, list, new ArrayList<>(curr));
        dfs(root.right, list, new ArrayList<>(curr));
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sol.sumRootToLeaf(root));
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
