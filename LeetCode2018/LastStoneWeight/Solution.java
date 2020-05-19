import java.util.*;
public class Solution{
    public int lastStoneWeight(int[] stones) {
        if(stones == null) return 0;
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        for(int i = 0; i < stones.length; i++){
            q.add(stones[i]);
        }
        while(q.size() > 1){
            int i = q.poll();
            int j = q.poll();
            if(i == j) {
                continue;
            }else{
                int k = i - j;
                q.add(k);
            }
        }
       return q.isEmpty() ? 0 : q.poll();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] arr = new int[] {2,7,4,1,8,1};

        System.out.println(sol.lastStoneWeight(arr));

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
