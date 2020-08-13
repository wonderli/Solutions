import java.util.*;
public class Solution2{
    public void duplicateZeros(int[] arr) {
        if(arr == null || arr.length == 0) return;
        int count = 0;
        for(int i = 0;  i < arr.length; i++){
            if(arr[i] == 0){
                count++;
            }
        }
        int len = arr.length + count;
        for(int i = arr.length - 1, j = len - 1; i < j; i--, j--){
            if(arr[i] != 0){
                if(j < arr.length) arr[j] = arr[i];
            }else {
                if(j < arr.length) arr[j] = arr[i];
                j--;
                if(j < arr.length) arr[j] = arr[i];
            }
        }
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
