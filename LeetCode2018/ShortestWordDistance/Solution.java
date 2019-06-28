import java.util.*;
public class Solution{
    public int shortestDistance(String[] words, String word1, String word2) {
        int len = words.length;
        List<Integer> w1list = new ArrayList<>();
        List<Integer> w2list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(words[i].equals(word1)){
                w1list.add(i);
            }else if(words[i].equals(word2)){
                w2list.add(i);
            }
        }
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < w1list.size(); i++){
            for(int j = 0; j < w2list.size(); j++){
                distance = Math.min(Math.abs(w1list.get(i) - w2list.get(j)), distance);
            }
        }
        return distance;
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
