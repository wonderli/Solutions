import java.util.*;
class Solution {
    public LLNode solve(LLNode node) {
        Deque<LLNode> stack = new ArrayDeque<>();
        LLNode curr = node;
        while(curr != null){
            while(stack.isEmpty() || (curr != null && curr.val <= stack.peek().val)){
                stack.push(curr);
                curr = curr.next;
            }
            if(curr == null){
                while(!stack.isEmpty()){
                    LLNode x = stack.pop();
                    x.val = 0;
                }
            }else{
                int v = curr.val;
                while(!stack.isEmpty() && v > stack.peek().val){
                    LLNode x = stack.pop();
                    x.val = v;
                }
            }
        }
        while(!stack.isEmpty()){
            LLNode x = stack.pop();
            x.val = 0;
        }

        return node;
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

