import java.util.*;
public class Solution{
    Map<Integer, Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for(int i = 0 ;i < post.length; i++){
            postMap.put(post[i], i);
        }
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
    public TreeNode helper(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int postRight){
        if(preLeft > preRight || postLeft > postRight) return null;
        TreeNode root = new TreeNode(pre[preLeft]);
        if(preLeft + 1 <= preRight){
            int index = postMap.get(pre[preLeft + 1]);
            int sum = index - postLeft;
            root.left = helper(pre, preLeft + 1, preLeft + sum + 1, post, postLeft, postLeft + sum);
            root.right = helper(pre, preLeft + sum + 2, preRight, post, postLeft + sum + 1, postRight - 1);
        }
        return root;
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
