import java.util.*;
public class Solution{
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        List<List<Integer>> levels = new ArrayList<>();
        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);
        while(!checkCurrLevelAllNull(currLevel)){
            List<Integer> currList = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode p : currLevel){
                TreeNode left = p != null ? p.left : null ;
                TreeNode right = p != null ? p.right : null;
                nextLevel.add(left);
                nextLevel.add(right);
                currList.add(left != null ? left.val : null);
                currList.add(right != null ? right.val : null);
            }
            currLevel = nextLevel;
            levels.add(currList);
        }
        return checkSymmetric(levels); 
    }
    private boolean checkCurrLevelAllNull(List<TreeNode> level){
        if(level == null || level.size() == 0) return true;
        for(TreeNode node : level){
            if(node != null) return false;
        }
        return true;
    }
    private boolean checkSymmetric(List<List<Integer>> levels){
        if(levels.size() == 0) return true;
        for(List<Integer> level : levels){
            if(!checkLevel(level)){
                return false;
            }
        }
        return true;
    }
    private boolean checkLevel(List<Integer> level){
        if(level.size() == 0) return true;
        int len = level.size();
        if(len % 2 != 0) return false;
        int i = 0;
        int j = len - 1;
        while(i < j){
            Integer a = level.get(i);
            Integer b = level.get(j);
            //System.out.println(a);
            //System.out.println(b);

            if((a == null && b == null) || (a != null && b != null && a.intValue() == b.intValue())) {
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode node = new TreeNode(1);
        TreeNode p = node;
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = null;
        p.left.right = new TreeNode(3);
        p.right.left = null;
        p.right.right = new TreeNode(3);
        System.out.println(sol.isSymmetric(p));
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
