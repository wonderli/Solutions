import java.util.*;
public class Solution2{
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> res = new ArrayList<>();
        while( i < arr1.length && j < arr2.length && k < arr3.length){
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            if(a == b && b == c){
                res.add(a);
                i++;
                j++;
                k++;
            }else if(a < b){
                i++;
            }else if(b < c){
                j++;
            }else {
                k++;
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
