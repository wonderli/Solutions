import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        TreeNode n = codec.deserialize("1,2,null,null,3,4,null,null,5,null,null,");
        sol.preorder(n);
    }
    private void preorder(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }


}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
        }else {
            sb.append(root.val);
            sb.append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return build(nodes);
    }
    private TreeNode build(Queue<String> nodes){
        String val = nodes.poll();
        if(val.equals("null")) return null;
        else{
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = build(nodes);
            root.right = build(nodes);
            return root;
        }
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
