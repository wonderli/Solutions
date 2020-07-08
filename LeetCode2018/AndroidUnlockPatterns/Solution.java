import java.util.*;
public class Solution{
	int[][] jumps;
	boolean[] visited;
    public int numberOfPatterns(int m, int n) {
        jumps = new int[10][10];
		jumps[1][3] = jumps[3][1] = 2;
		jumps[4][6] = jumps[6][4] = 5;
		jumps[7][9] = jumps[9][7] = 8;
		jumps[1][7] = jumps[7][1] = 4;
		jumps[2][8] = jumps[8][2] = 5;
		jumps[3][9] = jumps[9][3] = 6;
		jumps[1][9] = jumps[9][1] = 5;
		jumps[3][7] = jumps[7][3] = 5;
		visited = new boolean[10];
		int count = 0;
		count += dfs(1, 1, 0, m, n) * 4;
		count += dfs(2, 1, 0, m, n) * 4;
		count += dfs(5, 1, 0, m, n);
		return count;
    }
	private int dfs(int num, int len, int count, int m, int n){
		if(len >= m) count++;
		len++;
		if(len > n) return count;
		visited[num] = true;
		for(int next = 1; next <= 9; next++){
			int jump = jumps[num][next];
			if(!visited[next] && (jump == 0 || visited[jump])){
				count = dfs(next, len, count, m, n);
			}
		}
		visited[num] = false;
		return count;
	}
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.numberOfPatterns(1, 1));
        System.out.println(sol.numberOfPatterns(1, 2));
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
