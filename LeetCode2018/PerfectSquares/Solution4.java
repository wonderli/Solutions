import java.util.*;
public class Solution4{
    public int numSquares(int n) {
        List<Integer> squareNums = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            squareNums.add(i * i);
        }
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        while(queue.size() > 0){
            level++;
            Set<Integer> nextQueue = new HashSet<>();
            for(Integer remainder : queue){
                for(Integer square : squareNums){
                    if(remainder.equals(square)){
                        return level;
                    }else if(remainder < square){
                        break;
                    }else {
                        nextQueue.add(remainder - square);
                    }
                }
            }
            queue = nextQueue;
        }
        return level;
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
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
