//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution {
    public ListNode listNode = null;
    public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;
            int len = 0;
            ListNode n = head;
            while(n != null){
                n = n.next;
                len++;
            }
            listNode = head;
            return f(0, len - 1);
        }
        public TreeNode f(int start, int end){
            if(start > end) return null;
            int mid = start + (end - start)/2;
            TreeNode left = f(start, mid - 1);
            TreeNode root = new TreeNode(listNode.val);
            root.left = left;
            listNode = listNode.next;
            TreeNode right = f(mid + 1, end);
            root.right = right;
            
            return root;
        }
        public void inorder(TreeNode root){
            if(root == null) return;
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
        public static void main(String args[]){
            ListNode root = new ListNode(3);
            root.next = new ListNode(5);
            root.next.next = new ListNode(8);
            Solution s = new Solution();
            TreeNode n = s.sortedListToBST(root);
            s.inorder(n);
            
        }
}
