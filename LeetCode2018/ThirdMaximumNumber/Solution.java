import java.util.*;
public class Solution{
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int e : nums){
            set.add(e);
        }
        q.addAll(set);
        if(q.size() < 3){
            return q.poll();
        }
        q.poll();
        q.poll();
        return q.poll();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {2, 2, 3, 1};
        System.out.println(sol.thirdMax(a));
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
