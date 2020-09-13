import java.util.*;
public class Solution3{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        int original = image[sr][sc];
        if(original == newColor) return image;
        helper(image, sr, sc, original, newColor);
        return image;
    }
    public void helper(int[][] image, int sr, int sc, int original, int newColor){
        if(sr < 0||sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != original || image[sr][sc] == newColor){
            return;
        }
        image[sr][sc] = newColor;
        helper(image, sr - 1, sc, original, newColor);
        helper(image, sr + 1, sc, original, newColor);
        helper(image, sr, sc - 1, original, newColor);
        helper(image, sr, sc + 1, original, newColor);
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
