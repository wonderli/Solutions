import java.util.*;
import java.lang.*;
public class Solution{
    public int[] constructRectangle(int area) {
        if(area == 0) return new int[2];
        int sqrt = (int)Math.sqrt(area);
        while(area%sqrt != 0){
            sqrt--;
        }
        int ret[] = new int[2];
        ret[0] = area/sqrt;
        ret[1] = sqrt;
        return ret;
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
