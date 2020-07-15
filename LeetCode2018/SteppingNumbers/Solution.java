import java.util.*;
public class Solution{
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if(low > high) return res;
        Queue<Long> q = new LinkedList<>();
        for(long i = 1; i <= 9; i++) {
            q.add(i);
        }
        if(low == 0) res.add(0);
        while(!q.isEmpty()){
            long p = q.poll();
            if(p <= high/10){
                long last = p % 10;
                if(last > 0) q.add(p * 10 + last -1);
                if(last < 9) q.add(p * 10 + last + 1);
            }
            if(p >= low && p <= high){
                res.add((int)p);
            }
        }
        return res;
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
