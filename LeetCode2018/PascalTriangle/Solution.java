import java.util.*;
public class Solution{
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        curr.add(1);
        ret.add(curr);
        if(numRows == 1) return ret;
        curr = new LinkedList<>();
        curr.add(1);
        curr.add(1);
        ret.add(curr);
        for(int i = 2; i < numRows; i++){
            LinkedList<Integer> next = new LinkedList<>();
            for(int j = 1; j < curr.size(); j++){
                next.add(curr.get(j -1) + curr.get(j)); 
            }
            next.add(0, 1);
            next.add(next.size(), 1);
            ret.add(next);
            curr = next;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        List<List<Integer>> ret = sol.generate(5);
        for(List<Integer> e : ret){
            System.out.println(e);
        }
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
