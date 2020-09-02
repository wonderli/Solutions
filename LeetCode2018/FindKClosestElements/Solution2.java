import java.util.*;
public class Solution2{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = arr.length - k;
        while(l < r){
            int mid = l + (r - l)/2;
            if(x - arr[mid] > arr[mid + k] - x){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        for(int i = l; i < l + k; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
