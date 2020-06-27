import java.util.*;
class FirstUnique {

    private Set<Integer> queue = new LinkedHashSet<>();
    private Map<Integer, Boolean> unique = new HashMap<>();
    public FirstUnique(int[] nums) {
        for(int i: nums) {
        	this.add(i);
        }
    }

    public int showFirstUnique() {
        return queue.isEmpty() ? -1 : queue.iterator().next();
    }

    public void add(int value) {
        if(!unique.containsKey(value)) {
        	unique.put(value, true);
        	queue.add(value);
        } else if(unique.get(value)){
        	unique.put(value, false);
        	queue.remove(value);
        }
    }
}
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
		int[] nums = {7, 7, 7, 7, 7, 7};
		FirstUnique first = new FirstUnique(nums);
		System.out.println(	first.showFirstUnique());
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
