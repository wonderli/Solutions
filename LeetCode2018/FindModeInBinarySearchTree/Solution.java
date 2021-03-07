import java.util.*;
class Solution{
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        inorder(root); 
        for(Integer key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        max = Math.max(max, map.get(root.val));
        inorder(root.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
