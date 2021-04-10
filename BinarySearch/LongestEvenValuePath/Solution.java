import java.util.*;
class Solution {
    int max = 0;
    public int solve(Tree root) {
        if(root== null) return 0;
        helper(root);
        return max;
    }
    private int[] helper(Tree root){
        if(root== null) return new int[]{-1, -1};

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int l = Math.max(left[0], left[1]) + 1;
        int r = Math.max(right[0], right[1]) + 1;
        
        if(root.val % 2 == 0) {
            max = Math.max(l + r + 1, max);
            return new int[]{l, r};
        }else{
            max = Math.max(max, Math.max(l, r));
            return new int[]{-1, -1};
        }
    }
}
class Tree {
    int val;
    Tree left;
    Tree right;
}


