import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int solve(Tree root) {
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(l == r){
            return (1 << l) + solve(root.right);
        }else{
            return (1 << r) + solve(root.left);
        }
    }
    private int height(Tree root){
        if(root == null) return 0;
        return 1 + height(root.left);
    }
}
class Tree {
    int val;
    Tree left;
    Tree right;
}


