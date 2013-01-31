//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//
public class Solution{
    public int numTrees(int n) {
        if(n <= 1) return 1;
        int sum = 0;
        int left = 0;
        int right = 0;
        int root = 0;
        for(root = 1; root <= n; root++){
            left = numTrees(root - 1);
            right = numTrees(n - root);
            sum += left * right;
        }
        return sum;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int n = 3;
        System.out.println(sol.numTrees(n));
    }
}
