import java.util.*;
public class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return "null";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;
        while(!stack.isEmpty()){
            curr = stack.pop();
            sb.append(curr.val).append(",");
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s.equals("null")) return null;
        Queue<Integer> nodes = new LinkedList<>();
        String[] sArray = s.split(",");
        for(String e : sArray){
            nodes.add(Integer.valueOf(e));
        }

        return build(nodes);
    }
    public TreeNode build(Queue<Integer> nodes){
        if(nodes.isEmpty()) return null;
        Integer v = nodes.poll();
        TreeNode root = new TreeNode(v);
        Queue<Integer> small = new LinkedList<>();
        while(!nodes.isEmpty() && nodes.peek() < v){
            small.add(nodes.poll());
        }
        root.left = build(small);
        root.right = build(nodes);
        return root;
    }
    public static void main(String[] args){
        Codec2 codec = new Codec2();
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
