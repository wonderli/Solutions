import java.util.*;
public class Solution2{
    public int findJudge(int N, int[][] trust) {
        int[] score = new int[N+1];
        for(int[] relation : trust){
            score[relation[0]]++;
            score[relation[1]]--;
        }

        for(int i = 1; i <= N; i++){
            if(score[i] == -N + 1){
                return i;
            }
        }
        return -1;
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
