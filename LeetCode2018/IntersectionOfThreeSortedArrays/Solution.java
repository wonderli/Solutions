import java.util.*;
public class Solution{
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0;
        int j = 0;
        List<Integer> curr = new ArrayList<>();
        while( i < arr1.length && j < arr2.length){
            int a = arr1[i];
            int b = arr2[j];
            if(a == b){
                curr.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else if(b < a){
                j++;
            }
        }
        i = 0;
        j = 0;
        List<Integer> res = new ArrayList<>();
        while(i < curr.size() && j < arr3.length){
            int a = curr.get(i);
            int b = arr3[j];
            if(a == b){
                res.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else if(b < a){
                j++;
            }
        }


        return res;

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
