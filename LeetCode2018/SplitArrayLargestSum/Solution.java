import java.util.*;
public class Solution{
    public int splitArray(int[] nums, int m) {
        int maxNum = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(nums[i] > maxNum){
                maxNum = nums[i];
            }
        }
        if(m == 1) return sum;
        int low = maxNum;
        int high = sum;
        while(low < high){
            int mid = low + (high - low)/2;
            if(calSum(mid, m, nums)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean calSum(int mid, int m, int[] nums){
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > mid){
                sum = nums[i];
                count++;
                if(count > m - 1){
                    return false;
                }
            }
        }
        return true;
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
