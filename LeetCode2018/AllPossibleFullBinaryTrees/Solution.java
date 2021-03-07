import java.util.*;
class Solution{
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(map.containsKey(N)){
            return map.get(N);
        }
        List<TreeNode> res = new ArrayList<>();
        if(N == 1){
            res.add(new TreeNode(0));
        }else if(N % 2 == 1){
            for(int i = 0; i < N; i++){
                int j = N - i - 1;
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(j);
                for(TreeNode le : left){
                    for(TreeNode ri : right){
                        TreeNode root = new TreeNode(0);
                        root.left = le;
                        root.right = ri;
                        res.add(root);
                    }
                }
            }
            
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        List<TreeNode> res = sol.allPossibleFBT(7);
        System.out.println(res.size());

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
