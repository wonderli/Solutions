import java.util.*;
public class Solution{
    public void duplicateZeros(int[] arr) {
        if(arr == null || arr.length == 0) return;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                shift(arr, i);
                i++;
            }
        }
    }
    public void shift(int[] arr, int index){
        for(int i = arr.length - 1; i > index; i--){
            arr[i] = arr[i - 1];
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
