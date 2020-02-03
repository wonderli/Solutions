import java.util.*;
public class Solution{
    int result = Integer.MAX_VALUE;
    public int numSquares(int n) {
        if(n == 0) return 0;
        List<Integer> list = new ArrayList();
        list.add(1);
        for(int i = 2; i * i < n; i++){
            list.add(i * i);
        }
        count(n, list, list.size() - 1, 0);
        return result;
    }
    public void count(int n, List<Integer> list, int start, int current){
        if(n < 0) {
            return;
        }
        if(n == list.get(start)){
            current++;
            result = Math.min(current, result);
            return;
        }
        for(int i = start; i >= 0; i--){
            int v = list.get(i);
            count(n - v, list, i, current + 1);
        }
    }

    public static void main(String args[]){
        Solution sol = new Solution();
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
