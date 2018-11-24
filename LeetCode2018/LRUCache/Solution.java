import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));       
        cache.put(2, 6);
        System.out.println(cache.get(1));       
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));       
        System.out.println(cache.get(2));       
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
