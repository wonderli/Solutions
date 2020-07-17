import java.util.*;
public class Solution{
	char[] arr = {'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        helper(n, '-', k, sb);
        return sb.toString();
    }
    public void helper(int n, char last, int k, StringBuilder sb){
    	if(n == 0) {
    		return;
    	}
    	
    	int step = 1 << n - 1;
    	int total = step;
    	for(char c : arr) {
    		if(c == last) continue;
    		if(k <= total) {
    			helper(n - 1, c, k - (total - step), sb.append(c));
    			return;
    		}
    		total += step;
    	}
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.getHappyString(3, 9));
        System.out.println(sol.getHappyString(2, 7));
        System.out.println(sol.getHappyString(10, 100));
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
