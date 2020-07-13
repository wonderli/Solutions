import java.util.*;
public class Solution{
    public int countArrangement(int N) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        helper(1, N, visited, curr, res);
        //System.out.println(res);
        return res.size();
    }
    public void helper(int index, int N, boolean[] visited, List<Integer> curr, List<List<Integer>> res){
        if(index > N){
            res.add(curr);
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i] &&  (index % i == 0 || i % index == 0 )){
                visited[i] = true;
                List<Integer> tmp = new ArrayList<>(curr);
                curr.add(i);
                helper(index + 1, N,visited, curr, res); 
                curr = tmp;
                visited[i] = false;
            }
        }

    }
    public static void main(String args[]){
        Solution sol = new Solution();
        sol.countArrangement(2);
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
