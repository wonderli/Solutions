import java.util.*;
public class Solution{
     public List<Integer> grayCode(int n) {
         List<Integer> res = new ArrayList<>();
         if(n == 0){
             res.add(0);
             return res;
         }
         res.add(0);
         res.add(1);
         int i = 1;
         while(i < n){
             reflect(res);
             int len = res.size();
             for(int j = 0; j < len; j++){
                 int bit = 1;
                 if(j < len/2) {
                     bit = 0;
                 }
                 int curr = res.get(j);
                 curr = setBit(curr, i, bit);
                 res.set(j, curr);
             }
             i++;
         }
         return res;
    }
    public void reflect(List<Integer> list){
        for(int i = list.size() - 1; i >= 0; i--){
            list.add(list.get(i));
        }
    }
    public int setBit(int val, int i, int bit){
        return val | (bit << i);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.grayCode(2));
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
