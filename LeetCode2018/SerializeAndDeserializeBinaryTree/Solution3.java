import java.util.*;
public class Solution3{
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }
    public void helper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        helper(root.left, sb);
        helper(root.right, sb);
    }
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        List<String> list = new ArrayList();
        for(String e : d){
            list.add(e);
        }
        TreeNode root = helper(list);
        return root;
    }
    private TreeNode helper(List<String> list){
       if(list.isEmpty()) return null;
       String d =list.get(0);
       if(d.equals("null")){
           list.remove(0);
           return null;
       }

       TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
       list.remove(0);
       root.left = helper(list);
       root.right = helper(list);
       return root;
    }
    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        String s = codec.serialize(root);
        TreeNode r = codec.deserialize(s);
        System.out.println(r.val);

    }
}


    
