//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        boolean leftToright = true;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Stack<TreeNode> curr = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        curr.add(root);
        while(curr.size() != 0){
            TreeNode node = curr.pop();
            tmp.add(node.val);
            if(leftToright == true){
                if(node.left != null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
            }else{
                if(node.right != null){
                    next.add(node.right);
                }
                if(node.left != null){
                    next.add(node.left);
                }
            }
            if(curr.size() == 0){
                curr = next;
                next = new Stack<TreeNode>();
                ret.add(tmp);
                tmp = new ArrayList<Integer>();
                leftToright = !leftToright;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> ret = s.zigzagLevelOrder(root);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }

    }
}
