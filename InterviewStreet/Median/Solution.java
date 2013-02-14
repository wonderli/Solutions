import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
        TreeNode(int x){
            left = null;
            right = null;
            parent = null;
            val = x;
        }
    }
    public TreeNode r;
    public TreeNode toBeDelete;
    public int treeNodeNum(TreeNode root){
        if(root == null) return 0;
        int left = treeNodeNum(root.left);
        int right = treeNodeNum(root.right);
        return left + right + 1;
    }
    public void insert(int n){
        if(r == null){
            r = new TreeNode(n);
            return;
        }
        insert(r, n);
    }
    public void insert(TreeNode root, int n){
        if(root == null) 
            root = new TreeNode(n);
        else if(n < root.val){
            if(root.left == null){
                root.left = new TreeNode(n);
                root.left.parent = root;
            }else{
                insert(root.left, n);
            }
        }else{
            if(root.right == null){
                root.right = new TreeNode(n);
                root.right.parent = root;
            }else{
                insert(root.right, n);
            }
        }
    }
    public TreeNode search(TreeNode root, int n){
        if(root == null || root.val == n) return root;
        if(n < root.val){
            return search(root.left, n);
        }else{
            return search(root.right, n);
        }
    }
    public TreeNode minValue(TreeNode root){
        TreeNode curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
    public TreeNode maxValue(TreeNode root){
        TreeNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr;
    }
    public TreeNode successor(TreeNode root, TreeNode n){
        if(n.right != null){
            return minValue(n.right);
        }
        TreeNode succ = null;
        while(root != null){
            if(root.val > n.val){
                succ = root;
                root = root.left;
            }else if(root.val <= n.val){
                root = root.right;
            }else break;
        }
        return succ;
    }

    public TreeNode predecessor(TreeNode root, TreeNode n){
        if(n.left != null){
            return maxValue(n.left);
        }
        TreeNode prev = null;
        while(root != null){
            if(root.val < n.val){
                prev = root;
                root = root.right;
            }else if(root.val >= n.val){
                root = root.left;
            }else break;
        }
        return prev;
    }
    public boolean deleteNode(){
        if(r == null) return false;
        if(toBeDelete == null) return false;
        if(toBeDelete.left == null && toBeDelete.right == null){
            TreeNode parent = toBeDelete.parent;
            if(toBeDelete == parent.left){
                parent.left = null;
            }else{
                parent.right = null;
            }
            toBeDelete = null;
            return true;
        }
        if(toBeDelete.left != null && toBeDelete.right == null){
            TreeNode parent = toBeDelete.parent;
            parent.left = toBeDelete.left;
            toBeDelete.left.parent = parent;
            toBeDelete = null;
            return true;
        }
        if(toBeDelete.right != null && toBeDelete.left == null){
            TreeNode parent = toBeDelete.parent;
            parent.right = toBeDelete.right;
            toBeDelete.right.parent = parent;
            toBeDelete = null;
            return true;
        }
        if(toBeDelete.left != null && toBeDelete.right != null){
            TreeNode succ = successor(r, toBeDelete);
            toBeDelete.val = succ.val;
            toBeDelete = succ;
            return deleteNode();
        }
        return false;

    }
    public void solve(String order, int num){
        if(order.equals("r")){
            if(search(r, num) == null){
                System.out.println("Wrong!");
                return;
            }else{
                toBeDelete = search(r, num);
                deleteNode();
                System.out.println("Median is " + getMedian());
            }
        }else if(order.equals("a")){
            insert(num);
            System.out.println();
            System.out.println("Median is " + getMedian());
            System.out.println();
        }
    }
    public int getMedian(){
        int nodesNum = treeNodeNum(r);
        //System.out.println("Nodes Number: " + nodesNum);
        if(nodesNum % 2 == 1){
            return helper(nodesNum/2);
        }else {
            int l = helper(nodesNum/2);
            int x = 0;
            TreeNode c = search(r, l);
            TreeNode succ = successor(r, c);
            //System.out.println("Even " + succ.val + " + " + l);
            if(succ != null){
               x = succ.val;
            }else{
                TreeNode prev = predecessor(r, c);
                x = prev.val;
                
            }
            return (x + l)/2;
        }
    }
    public int helper(int k){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pCrawl = r;
        while(pCrawl != null){
            stack.push(pCrawl);
            pCrawl = pCrawl.left;
        }
        while(!stack.isEmpty()){
            pCrawl = stack.pop();
            if(k == 0){
                break;
            }
            k--;
            if(pCrawl.right != null){
                pCrawl = pCrawl.right;
                while(pCrawl != null){
                    stack.push(pCrawl);
                    pCrawl = pCrawl.left;
                }
            }
        }
        return pCrawl.val;

    }
    public void print(TreeNode root){
        if(root == null) return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
        //TreeNode succ = null;
        //TreeNode prev = null;
        //while((succ = successor(r, root)) != null){
        //  //prev = predecessor(r, succ);
        //  System.out.println("curr is " + root.val + " successor is " + succ.val);
        //  //System.out.println("succ is " + succ.val + " predecessor is " + prev.val);
        //  root = succ;
        //}
        //for(int i = 0; i <= treeNodeNum(root); i++){
        //    System.out.println(helper(i));
        //}
    }
    public void buildTree(){
        insert(2);
        insert(1);
        insert(4);
        insert(5);
        insert(10);
        insert(15);
        insert(14);
        insert(20);
        toBeDelete = search(r, 20);
        deleteNode();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        sol.r = null;
        sol.toBeDelete = null;
        //int N = sc.nextInt();
        //while(sc.hasNext()){
        //    String action = sc.next();
        //    int num = Integer.parseInt(sc.next());
        //    sol.solve(action, num);
        //    System.out.println("Tree: ");
        //    sol.print(sol.r);
        //    System.out.println();
        //    //System.out.println("Nodes: " + sol.treeNodeNum(sol.r));
        //}
        sol.buildTree();
        sol.print(sol.r);
        System.out.println("wtf");
        //sol.getMedian();
    }
}
