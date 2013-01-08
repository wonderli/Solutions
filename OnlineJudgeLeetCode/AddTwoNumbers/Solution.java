public class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null && l2 == null) return null;
            int carry = 0;
            int result = 0;
            if(l1 != null){
                result += l1.val;
            }
            if(l2 != null){
                result += l2.val;
            }
            carry = result / 10;
            result = result % 10;
            ListNode root = new ListNode(result);
            ListNode ret = root;
            l1 = l1.next;
            l2 = l2.next;
            while(l1 != null && l2 != null){
                result = 0;
                if(l1 != null){
                    result += l1.val;
                }
                if(l2 != null){
                    result += l2.val;
                }
                result += carry;
                carry = result / 10;
                result = result % 10;
                ret.next = new ListNode(result);
                ret = ret.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(l1 == null && l2 != null){
                while(l2 != null){
                    result = 0;
                    result += carry;
                    result += l2.val;
                    carry = result / 10;
                    result = result % 10;
                    ret.next = new ListNode(result);
                    ret = ret.next;
                    l2 = l2.next;
                }
            }
            if(l2 == null && l1 != null){
                while(l1 != null){
                    result = 0;
                    result += carry;
                    result += l1.val;
                    carry = result / 10;
                    result = result % 10;
                    ret.next = new ListNode(result);
                    ret = ret.next;
                    l1 = l1.next;
                }
            }
            if(carry != 0){
                ret.next = new ListNode(carry);
                carry = 0;
            }
            return root;
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
