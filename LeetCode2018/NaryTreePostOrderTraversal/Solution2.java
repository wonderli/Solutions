import java.util.*;
public class Solution2{
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node node = stack.pop();
            ans.add(node.val);
            List<Node> list = node.children;
            for(int i = 0; i < list.size(); i++){
                stack.push(list.get(i));
            }
        }
        Collections.reverse(ans);
        return ans;
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
