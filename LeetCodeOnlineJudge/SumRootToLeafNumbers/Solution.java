public class Solution{
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int res[] = new int[1];
        res[0] = 0;
        helper(root, res, 0);
        return res[0];
    }
    public void helper(TreeNode root, int res[], int curr){
        if(root == null) return;
        if(root.left == null && root.right == null){
            curr = curr * 10 + root.val;
            res[0] += curr;
        }
        helper(root.left, res, curr * 10 + root.val);
        helper(root.right, res, curr * 10 + root.val);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sol.sumNumbers(root));
    }
}
