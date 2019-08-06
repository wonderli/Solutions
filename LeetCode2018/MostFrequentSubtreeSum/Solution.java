import java.util.*;
public class Solution{
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return new int[0];
        helper(root);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(val == max){
                ret.add(key);
            }
        }
        int[] res = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            res[i] = ret.get(i);
        }
        return res;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int val = root.val + helper(root.left) + helper(root.right);
        int times = map.getOrDefault(val, 0);
        if(times > 0){
            map.put(val, times++); 
            max = Math.max(max, times);
        }
        return val;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(Arrays.toString(sol.findFrequentTreeSum(root)));

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
