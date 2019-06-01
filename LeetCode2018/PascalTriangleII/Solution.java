import java.util.*;
public class Solution{
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        if(rowIndex == 0) return prev;
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        curr.add(1);
        if(rowIndex == 1) return curr;
        for(int i = 2; i <= rowIndex; i++){
            prev = curr;
            curr = new ArrayList<>();
            curr.add(1);
            for(int j = 1; j < prev.size(); j++){
                int value = prev.get(j) + prev.get(j-1);
                curr.add(value);
            }
            curr.add(1);
        }
        return curr;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.getRow(3));
        System.out.println(sol.getRow(5));
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
