import java.util.*;
public class Solution{
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String s = "123456789";
        int n = 10;
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for(int level = lowLen; level < highLen + 1; level++){
            for(int i = 0; i < n -  level ; i++){
                Integer num = Integer.parseInt(s.substring(i, i+level));
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.sequentialDigits(10, 1000));
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
