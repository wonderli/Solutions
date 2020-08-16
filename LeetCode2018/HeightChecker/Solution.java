import java.util.*;
public class Solution{
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for(int e : heights){
            count[e]++;
        }
        int num = 0;
        int next = 0;
        for(int i = 0; i < heights.length; i++){
            next = nextNum(count, next);
            if(heights[i] != next){
                num++;
            }
            count[next]--;
        }
        return num;
    }
    public int nextNum(int[] count, int next){
        while(count[next] == 0){
            next++;
        }
        return next;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {1, 1, 4, 2, 1, 3};
        System.out.println(sol.heightChecker(a));
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
