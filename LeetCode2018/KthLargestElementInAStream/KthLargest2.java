import java.util.*;
public class KthLargest2{
    private Node root;
    private int k = 0;
    public KthLargest2(int k, int[] nums) {
        root = null;
        for(int n : nums){
            root = insertNode(root, n);
        }
        this.k = k;
    }
    private Node insertNode(Node root, int val){
        if(root == null){
            return new Node(val, 1);
        }
        if(root.val < val){
            root.right = insertNode(root.right, val);
        }else {
            root.left = insertNode(root.left, val);
        }
        root.count++;
        return root;
    }
    private int search(Node root, int k){
        // m is the size of the right subtree
        int m = root.right != null ? root.right.count : 0;
        if(k == m + 1){
            return root.val;
        }
        if(k <= m){
            return search(root.right, k);
        }else {
            return search(root.left, k - m - 1);
        }
    }

    public int add(int val) {
        root = insertNode(root, val);
        return search(root, k);
    }

    public static void main(String args[]){
        int[] a = {4, 5, 8, 2};
        KthLargest2 sol = new KthLargest2(3, a);
        System.out.println(sol.add(3));
        System.out.println(sol.add(5));
        System.out.println(sol.add(10));
        System.out.println(sol.add(9));
        System.out.println(sol.add(4));
    }
}

class Node{
    Node left;
    Node right;
    int val;
    int count;
    public Node(int val, int count){
        left = null;
        right = null;
        this.val = val;
        this.count = count;

    }
}
