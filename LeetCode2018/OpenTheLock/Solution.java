import java.util.*;
public class Solution{
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for(String s : deadends){
            dead.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        queue.add(null);
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        int depth = 0;
        while(!queue.isEmpty()){
            String node = queue.poll();
            if(node == null){
                depth++;
                if(queue.peek() != null){
                    queue.add(null);
                }
            }else if(node.equals(target)){
                return depth;
            }else if(!dead.contains(node)){
                for(int i = 0; i < 4; i++){
                    for(int d = -1; d <= 1; d+=2){
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                        if(!seen.contains(nei)){
                            seen.add(nei);
                            queue.add(nei);
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
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
