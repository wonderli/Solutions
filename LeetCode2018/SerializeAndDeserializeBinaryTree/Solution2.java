import java.util.*;
public class Solution2{
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr != null){
                    sb.append(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }else{
                    sb.append("null");
                }
                sb.append(",");
            }
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] vals = data.split(",");
        if(vals == null || vals.length == 0) return null;
        String n = "null";
        Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
		queue.add(root);
		int index = 1;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode curr = queue.poll();
				for(int j = index; j < index + 2 && j < vals.length; j++){
					if(vals[j].equals("null")){
						if(j%2 == 1){
							curr.left = null;
						}else {
							curr.right = null;
						}
					}else {
						TreeNode next = new TreeNode(Integer.valueOf(vals[j]));
						queue.add(next);
						if(j % 2 == 1){
							curr.left = next;
						}else {
							curr.right = next;
						}
					}
				}
				index = index + 2;
			}
		}
        return root;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
