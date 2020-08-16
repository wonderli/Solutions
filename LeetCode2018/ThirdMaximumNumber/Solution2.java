import java.util.*;
public class Solution2{
    public int thirdMax(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int e : nums){
            set.add(e);
        }
        if(set.size() < 3){
            return Collections.max(set);
        }
        set.remove(Collections.max(set));
        set.remove(Collections.max(set));
        return Collections.max(set);
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
