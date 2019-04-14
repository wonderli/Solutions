import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] n1 = {1, 1, 2};
        System.out.println(sol.removeDuplicates(n1));
        int[] n2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(sol.removeDuplicates(n2));
    }
    public int removeDuplicates(int[] num) {
        if(num == null|| num.length == 0) {
            return 0;
        }
        int len = num.length;
        int i = 0;
        int j = 0;
        while(j < len){
            if(num[j] == num[i]){
                j++;
            }else {
                i++;
                swap(num, j, i);
                j++;
            }
        }
        //System.out.println(Arrays.toString(num));
        return i + 1;
    }
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
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
