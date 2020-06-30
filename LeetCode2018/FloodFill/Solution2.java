import java.util.*;
public class Solution2{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor){
            dfs(image, sr, sc, oldColor, newColor);
        }
        return image;
    }
    public void dfs(int[][] image, int r, int c, int oldColor, int newColor){
        if(image[r][c] == oldColor){
            image[r][c] = newColor;
            if(r > 0) dfs(image, r-1, c, oldColor, newColor);
            if(r < image.length -1) dfs(image, r+1, c, oldColor, newColor);
            if(c > 0) dfs(image, r, c-1, oldColor, newColor);
            if(c < image[0].length - 1) dfs(image, r, c+1, oldColor, newColor);
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
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
