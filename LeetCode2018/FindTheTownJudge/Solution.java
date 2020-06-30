import java.util.*;
public class Solution{
    public int findJudge(int N, int[][] trust) {
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        for(int[] relation : trust){
            out[relation[0]]++;
            in[relation[1]]++;
        }
        for(int i = 1; i <= N; i++){
            if(in[i] == N -1 && out[i] == 0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[][] trust = {{1,2}};
        System.out.println(sol.findJudge(2, trust));
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
