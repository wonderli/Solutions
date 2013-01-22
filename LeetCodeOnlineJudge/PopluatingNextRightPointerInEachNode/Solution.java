//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
public class Solution{
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        solve(root, null);
    }
    public void solve(TreeLinkNode curr, TreeLinkNode parent){
        if(curr == null) return;
        if(parent != null){
            if(curr == parent.left && parent.right != null){
                curr.next = parent.right;
            }else{
                curr.next = parent.next == null ? null : parent.next.left;
            }
        }else{
            curr.next = null;
        }
        solve(curr.left, curr);
        solve(curr.right, curr);
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        TreeLinkNode r = new TreeLinkNode(1);
        r.left = new TreeLinkNode(2);
        r.right = new TreeLinkNode(3);
        sol.connect(r);
    }
}
