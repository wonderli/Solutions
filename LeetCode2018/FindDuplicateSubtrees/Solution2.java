import java.util.*;
public class Solution2{
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, map, ret);
        return ret;
    }
    public String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> ret){
        if(root == null){
            return "";
        }
        String key = root.val + "l" + helper(root.left, map, ret) + "r" + helper(root.right, map, ret);
        int count = map.getOrDefault(key, 1);
        if(count == 2){
            ret.add(root);
        }
        map.put(key, count + 1);
        return key;
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

