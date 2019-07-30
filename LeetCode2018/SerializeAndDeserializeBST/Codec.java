import java.util.*;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root, sb);
        return sb.toString();
    }
    public void sHelper(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        sHelper(root.left, sb);
        sHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(s.split(",")));
        return build(nodes);
    }
    public TreeNode build(Queue<String> nodes){
        String v = nodes.poll();
        if(v.equals("null")){
            return null;
        }else {
            TreeNode root = new TreeNode(Integer.valueOf(v));
            root.left = build(nodes);
            root.right = build(nodes);
            return root;
        }
    }
    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        //TreeNode root = null;
        System.out.println(codec.serialize(root));
        String s = codec.serialize(root);
        codec.deserialize(s);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
