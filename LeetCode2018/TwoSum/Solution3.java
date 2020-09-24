import java.util.*;
public class Solution3{
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            int b = target - a;
            if(map.containsKey(b)){
                ret[0] = i;
                ret[1] = map.get(b);
            }
            map.put(a, i);
        }
        return ret;
    }

    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
