import java.util.*;
public class Solution2{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, visited, 0);
        for(boolean b : visited){
            if(!b){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, boolean[] visited, int from){
        List<Integer> keys = rooms.get(from);
        for(int k : keys){
            if(!visited[k]){
                visited[k] = true;
                dfs(rooms, visited, k);
            }
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
