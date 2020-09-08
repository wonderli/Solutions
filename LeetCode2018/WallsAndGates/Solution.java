import java.util.*;
public class Solution{
    int EMPTY = Integer.MAX_VALUE;
    int GATE = 0;
    List<int[]> directions = Arrays.asList(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(rooms[r][c] == GATE){
                    q.add(new int[]{r, c});
                }
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            int row = p[0];
            int col = p[1];
            for(int[] direction : directions){
                int r = row + direction[0];
                int c = col + direction[1];
                if(r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY){
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r, c});
            }
        }
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
