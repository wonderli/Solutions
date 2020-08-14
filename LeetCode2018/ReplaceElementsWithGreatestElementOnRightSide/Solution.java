import java.util.*;
public class Solution{
    public int[] replaceElements(int[] arr) {
        if(arr == null || arr.length == 0) return arr;
        int max = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
        	int tmp = arr[i];
            arr[i] = Math.max(max, arr[i+1]);
            max = Math.max(tmp, max);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(sol.replaceElements(a)));
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
