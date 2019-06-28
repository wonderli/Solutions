import java.util.*;
public class Solution2{
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1loc = -1;
        int w2loc = -1;
        int len = words.length;
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            if(words[i].equals(word1)){
                w1loc = i;
            }else if(words[i].equals(word2)){
                w2loc = i;
            }else{
                continue;
            }
            if(w1loc != -1 && w2loc != -1){
                distance = Math.min(distance, Math.abs(w1loc - w2loc));
            }
        }
        return distance;
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
