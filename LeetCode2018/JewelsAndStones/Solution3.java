import java.util.*;
public class Solution3{
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(char c : J.toCharArray()){
            set.add(c);
        }
        int count = 0;
        for(char c : S.toCharArray()){
            if(set.contains(c)){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
