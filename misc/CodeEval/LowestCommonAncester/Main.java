import java.util.*;
import java.io.*;
public class Main {
    public static TreeNode buildTreeNode(){
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(8);
        root.right = new TreeNode(52);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(20);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(29);
        return root;
    }
    public static int solve(TreeNode root, int a, int b){
        if(root == null) return -1;
        if(root.val > a && root.val < b) return root.val;
        else if(root.val > a && root.val > b) return solve(root.left, a, b);
        //else if(root.val < a && root.val < b) return solve(root.right, a, b);
        else return solve(root.right, a, b);
    }
    public static void main (String[] args) {
        TreeNode root = buildTreeNode();
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String s[] = line.split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                System.out.println(solve(root, a, b));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        left = null;
        right = null;
        this.val = val;
    }
}
