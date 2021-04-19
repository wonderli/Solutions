import java.util.*;

/**
Given a binary tree root, return the maximum sum of a subtree. A subtree is defined to be some node in root including all of its descendants. A subtree sum is the sum of all the node values in the subtree. A subtree can be null in which case its sum is 0.

Constraints

1 ≤ n ≤ 100,000 where n is the number of nodes in root
Example 1
Input
Visualize
root = [3, [0, null, null], [2, [0, null, null], null]]
Output
5

*/
class Solution {
    int max = 0;
    public int solve(Tree root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
    private int helper(Tree root){
        if(root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int curr = root.val + l + r;
        max = Math.max(curr, max);
        return curr;
    }
}
class Tree {
    int val;
    Tree left;
    Tree right;
}
