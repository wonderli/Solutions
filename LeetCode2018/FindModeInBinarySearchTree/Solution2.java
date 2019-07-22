import java.util.*;
public class Solution2{
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        if(prev != null){
            if(prev == root.val){
                count++;
            }
        }
        if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        } else if(count == max){
            list.add(root.val);
        }
        prev = root.val;
        inorder(root.right, list);
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
