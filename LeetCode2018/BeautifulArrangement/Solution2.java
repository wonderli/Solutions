import java.util.*;
public class Solution2{
    int count = 0;
    public int countArrangement(int N) {
        if(N == 0) return 0;
        helper(1, N, new boolean[N+1]);
        return count;
    }
    public void helper(int pos, int N, boolean[] visited){
        if(pos > N) {
            count++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i] && (pos % i == 0 || i %pos == 0)){
                visited[i] = true;
                helper(pos + 1, N, visited);
                visited[i] = false;
            }
        }

    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
