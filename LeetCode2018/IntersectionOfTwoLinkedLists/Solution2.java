import java.util.*;
public class Solution2{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode first = lenA < lenB ? headA : headB;
        ListNode second = lenA < lenB ? headB : headA;
        int diff = Math.abs(lenB - lenA);
        for(int i = 0; i < diff; i++){
            second = second.next;
        }
        while(first != null && second != null && first != second){
            first = first.next;
            second = second.next;
        }
        if(first == null || second == null){
            return null;
        }
        return first;

    }
    public int getLen(ListNode node){
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
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
