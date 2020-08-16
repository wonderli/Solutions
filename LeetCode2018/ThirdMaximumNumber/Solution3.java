import java.util.*;
public class Solution3{
    public int thirdMax(int[] nums){
        Integer m1 =null;
        Integer m2 =null;
        Integer m3 = null;
        for(Integer e :nums){
            if(e.equals(m1) || e.equals(m2)||e.equals(m3)) continue;
            if(m1==null || e > m1){
                m3 = m2;
                m2 = m1;
                m1 = e;
            }else if(m2 == null || e > m2){
                m3 = m2;
                m2 =e;
            }else if(m3 == null || e > m3){
                m3 =e;
            }
        }
        return m3 == null ? m1 : m3;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
