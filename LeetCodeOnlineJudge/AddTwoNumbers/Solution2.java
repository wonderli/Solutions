//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
public class Solution2 {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            int carry = 0;
            int currVal = 0;
            ListNode root = new ListNode(0);
            ListNode curr = root;
            while(l1 != null || l2 != null){
                int a = (l1 != null) ? l1.val : 0;
                int b = (l2 != null) ? l2.val : 0;
                currVal = (a + b + carry) %10;
                carry = (a + b + carry)/10;
                curr.next = new ListNode(currVal);
                curr = curr.next;
                l1 = (l1 != null) ? l1.next : null;
                l2 = (l2 != null) ? l2.next : null;
            }
            if(carry != 0){
                curr.next = new ListNode(carry);
            }
            return root.next;
        }
        public static void printNode(ListNode n){
            while(n != null){
                System.out.print(n.val + "->");
                n = n.next;
            }
            System.out.println();
        }

        public static void main(String args[]){
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(8);
            l1.next.next = new ListNode(3);
            ListNode l2 = new ListNode(0);
            //l2.next = new ListNode(6);
            //l2.next.next = new ListNode(4);
            printNode(l1);
            printNode(l2);
            ListNode r = addTwoNumbers(l1, l2);
            printNode(r);

        }
}
