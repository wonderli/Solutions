import java.util.*;
public class Solution2{
    public boolean checkIfExist(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int e : arr){
            if(set.contains(e * 2) || (e%2 == 0 && set.contains(e/2))){
                return true;
            }
            set.add(e);
        }
        return false;
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
