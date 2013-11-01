import java.util.*;
public class Solution{
    public int removeDuplicates(int[] A) {
       if(A == null || A.length == 0) return 0; 
       if(A.length < 3) return A.length;
       int len = A.length;
       int j = 1;
       int i = 2;
       while(i < len){
           if(A[i] == A[j-1] && A[i] == A[j]){
               i++;
           }else{
               j++;
               A[j] = A[i];
               i++;
           }
       }
        
       return j+1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int A[] = {1, 1, 1, 2, 2, 3};
        int A[] = {1, 2, 2};
        System.out.println(Arrays.toString(A));
        System.out.println(sol.removeDuplicates(A));
        System.out.println(Arrays.toString(A));
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
