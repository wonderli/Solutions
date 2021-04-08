import java.util.*;
class Solution{
	public static void main(String args[]){
		Solution sol = new Solution();
	}
}
class LLNode {

	int val;
	LLNode next;
	public LLNode(){
	}
	public LLNode(int v){
		this(v, null);
	}
	public LLNode(int v, LLNode next){
		this.val = v;
		this.next = next;
	}
	public void print(LLNode p){
		while(p != null){
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LLNode{");
		sb.append("val=").append(val);
		sb.append(", next=").append(next);
		sb.append('}');
		return sb.toString();
	}
}

