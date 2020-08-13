import java.util.*;
public class Solution{
    public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
            if(arr[i] == 0) count++;
        }
        if(count >= 2) return true;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] == 0) continue;
            if(set.contains(arr[j] * 2)){
                return true;
            }
        }
        return false;
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
