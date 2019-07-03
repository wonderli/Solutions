import java.util.*;
public class Solution{

    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        return sum(nestedList, 1);
    }
    public int sum(List<NestedInteger> nestedList, int depth){
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int res = 0;
        for(NestedInteger nestedInteger : nestedList){
            res += sum(nestedInteger, depth);
        }
        return res;
    }
    public int sum(NestedInteger nestedInteger, int depth){
        if(nestedInteger.isInteger()){
            return nestedInteger.getInteger() * depth;
        }else{
            return sum(nestedInteger.getList(), depth+1);
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
