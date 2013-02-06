public class Solution{
    public int maxPathSum(TreeNode root){
        int currSum[] = new int[1];
        currSum[0] = 0;
        int maxSum[] = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        helper(root, currSum, maxSum);
        return maxSum[0];
    }
    public void helper(TreeNode root, int[] currSum, int[] maxSum){
        if(root == null){
            currSum[0] = 0;
            return;
        }
        int[] leftSum = new int[1];
        int[] rightSum = new int[1];
        helper(root.left, leftSum, maxSum);
        helper(root.right, rightSum, maxSum);
        currSum[0] = Math.max(root.val, Math.max(leftSum[0] + root.val, rightSum[0] + root.val));
        maxSum[0] = Math.max(maxSum[0], Math.max(currSum[0], leftSum[0] + root.val + rightSum[0]));
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(0);
        System.out.println(sol.maxPathSum(root));
    }
}
