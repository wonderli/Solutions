import java.util.*;
public class Solution2{
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 60; j++){
                if(Integer.bitCount(i) + Integer.bitCount(j) == num){
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
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
