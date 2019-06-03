import java.util.*;
public class Solution{
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] ret = new int[2];
        while(i < j){
            if(numbers[i] + numbers[j] > target){
                j--;
            }else if(numbers[i] + numbers[j] < target){
                i++;
            } else{
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] n = {2,7,11,15};
        System.out.println(Arrays.toString(sol.twoSum(n, 9)));
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
