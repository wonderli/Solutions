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
        double val;
        TreeNode(double x){
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
    public void insert(double n){
        if(r == null){
            r = new TreeNode(n);
            return;
        }
        insert(r, n);
    }
    public void insert(TreeNode root, double n){
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
    public TreeNode search(TreeNode root, double n){
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
    public void transplant(TreeNode x, TreeNode y){
        if(x.parent == null){
            r = y;
        }else if(x == x.parent.left){
            x.parent.left = y;
        }else 
            x.parent.right = y;
        if(y != null){
            y.parent = x.parent;
        }
    }
    public void deleteNode(){
        if(toBeDelete.left == null){
            transplant(toBeDelete, toBeDelete.right);
        }else if(toBeDelete.right == null){
            transplant(toBeDelete, toBeDelete.left);
        }else{
            TreeNode y = minValue(toBeDelete.right);
            if(y.parent != toBeDelete){
                transplant(y, y.right);
                y.right = toBeDelete.right;
                y.right.parent = y;
            }
            transplant(toBeDelete, y);
            y.left = toBeDelete.left;
            y.left.parent = y;
        }

    }
    public void solve(String order, double num, StringBuilder sb){
        if(order.equals("r")){
            if(search(r, num) == null){
                //System.out.println("Wrong!");
                sb.append("Wrong!\n\n");
                return;
            }else{
                toBeDelete = search(r, num);
                deleteNode();
                if(r == null){
                    sb.append("Wrong!\n\n");
                    return;
                }
                //System.out.println("Median is " + getMedian());
                sb.append(getMedian());
                sb.append("\n\n");
            }
        }else if(order.equals("a")){
            insert(num);
            //System.out.println();
            //System.out.println("Median is " + getMedian());
            //System.out.println();
            sb.append(getMedian());
            sb.append("\n\n");
        }
    }
    public double getMedian(){
        int nodesNum = treeNodeNum(r);
        //System.out.println("Nodes Number: " + nodesNum);
        if(nodesNum % 2 == 1){
            return helper(nodesNum/2);
        }else {
            double l = helper(nodesNum/2);
            double x = 0;
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
    
    public double helper(int k){
        if(k == 0) return minValue(r).val;
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
        System.out.println(root.val + " " + "parent " + ((root.parent == null) ? "NULL " : root.parent.val));
        //System.out.print(root.val + " " + "parent " + ((root.parent == null) ? "NULL " : root.parent.val));
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
        insert(1);
        System.out.println();
        print(r);
        insert(1);
        System.out.println();
        print(r);
        insert(2);
        System.out.println();
        print(r);
        //insert(5);
        //insert(10);
        //insert(15);
        //insert(14);
        //insert(20);
        toBeDelete = search(r, 1);
        deleteNode();
        System.out.println();
        print(r);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        sol.r = null;
        sol.toBeDelete = null;
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String action = sc.next();
            double num = Double.parseDouble(sc.next());
            sol.solve(action, num, sb);
            //sol.print(sol.r);
            //System.out.println();
            //System.out.println("Nodes: " + sol.treeNodeNum(sol.r));
        }
        //sol.buildTree();
        //sol.print(sol.r);
        //System.out.println("wtf");
        //sol.getMedian();
        System.out.println();
        System.out.println(sb.toString());
    }
}
