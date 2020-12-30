import java.util.*;
public class Solution2{
	private class Pair{
		TreeNode node;
		int index;
		public Pair(TreeNode node, int index){
			this.node = node;
			this.index = index;
		}
	}
	public int widthOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		Queue<Pair> queue = new LinkedList<>();
		int maxWidth = 0;
		queue.add(new Pair(root, 0));
		while(!queue.isEmpty()){
			int size = queue.size();
			Pair first = queue.peek();
			Pair curr = null;
			for(int i = 0; i < size; i++){
				curr = queue.poll();
				TreeNode node= curr.node;
				if(node.left != null){
					queue.add(new Pair(node.left, curr.index * 2));
				}
				if(node.right != null){
					queue.add(new Pair(node.right, curr.index * 2 + 1));
				}
			}
			maxWidth = Math.max(maxWidth, (curr.index - first.index+1));
		}
		return maxWidth;
	}
	public static void main(String args[]){
		Solution2 sol = new Solution2();
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {};
	TreeNode(int x) { val = x; }
}

