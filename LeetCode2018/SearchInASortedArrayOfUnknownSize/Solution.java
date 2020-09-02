import java.util.*;
public class Solution{
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 10000;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(reader.get(r) == 2147483647){
                r--;
            }else if(reader.get(mid) < target){
                l = mid + 1;
            }else if(reader.get(mid) > target){
                r = mid - 1;
            }else if(reader.get(mid) == target){
                return mid;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
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
