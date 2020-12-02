import java.util.*;
public class Solution4{
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left +"," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        index = 0;
        return helper(s);
    }
    int index = 0;
    private TreeNode helper(String[] s){
        if(index == s.length) return null;
        if(s[index].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s[index]));
        index++;
        root.left = helper(s);
        index++;
        root.right = helper(s);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
