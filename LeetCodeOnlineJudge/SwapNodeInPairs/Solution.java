// Given a linked list, swap every two adjacent nodes and return its head.
//
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
//
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
public class Solution{
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode a = head;
        ListNode b = null;
        if(head.next != null){
            b = head.next;
        }else{
            return a;
        }
        ListNode tmp = b.next;
        b.next = a;
        a.next = swapPairs(tmp);
        return b;
    }
    public static void printList(ListNode root){
        ListNode pCrawl = root;
        while(pCrawl != null){
            System.out.print(pCrawl.val + " ");
            pCrawl = pCrawl.next;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        printList(root);
        ListNode a = sol.swapPairs(root);
        System.out.println();
        printList(a);
    }
}
