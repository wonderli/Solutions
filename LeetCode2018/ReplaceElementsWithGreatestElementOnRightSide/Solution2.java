import java.util.*;
public class Solution2{
    public int[] replaceElements(int[] arr) {
        if(arr == null || arr.length == 0) return arr;
        int max = -1;
        for(int i = arr.length - 1; i >= 0; i--){
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(tmp, max);
        }
        return arr;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
