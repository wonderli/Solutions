import java.util.*;
class Solution2 {
	private class Node {
		public int val;
		public List<Node> children;


		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val,ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}
	public Node findRoot(List<Node> tree) {
		int valueSum = 0;
		for(Node n : tree){
			valueSum += n.val;
			for(Node c : n.children){
				valueSum -= c.val;
			}
		}
		Node root = null;
		for(Node n : tree){
			if(n.val == valueSum){
				return n;
			}
		}
		return null;
	}

}
