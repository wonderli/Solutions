import java.util.*;
public class Solution2{
    public int firstBadVersion(int n){
        int i = 0;
        int j = n;
        while(i < j){
            int mid = i + (j - i)/2;
            if(isBadVersion(mid)){
                j = mid;
            }else {
                i = mid + 1;
            }
        }
        return i;
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
