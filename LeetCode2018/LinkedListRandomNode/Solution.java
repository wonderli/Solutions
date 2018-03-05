import java.util.*;
public class Solution{
    ListNode node;
    public Solution(ListNode head) {
        node = head;
    }
    public int getRandom() {
        Random random = new Random();
        ListNode curr = node;
        int ret = curr.val;
        for(int i = 1; curr.next != null; i++) {
            curr = curr.next;
            if(random.nextInt(i + 1) == i) {
                ret = curr.val;
            }
        }
        return ret;
    }

    public static void main(String args[]){
        //Solution sol = new Solution();
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
