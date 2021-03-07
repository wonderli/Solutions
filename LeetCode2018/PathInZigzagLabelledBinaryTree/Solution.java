import java.util.*;
public class Solution{
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ret = new ArrayList<>();
        ret.add(label);
        double level = findLevel(label);
        double doubleLabel = (double)label;
        while(level > 1){
            double upperNode = findUpperNode(level, doubleLabel);
            doubleLabel = upperNode;
            ret.add((int)doubleLabel);
            level--;
        }

        Collections.reverse(ret);
        return ret;
    }
    public double findUpperNode(double level, double child){
        double max = Math.pow(2.0, level) - 1;
        double min = Math.pow(2.0, level-1);
        boolean isAsending = (level %2) == 1;
        double start = isAsending ? min : max;
        double parentLevelMax = Math.pow(2.0, level - 1) - 1;
        double parentLevelMin = Math.pow(2.0, level - 2);
        double parentStart = isAsending ? parentLevelMax : parentLevelMin;
        int upperNodeLoc = (int)((start - child)/2);
        double res =  parentStart + (double)upperNodeLoc;
        return res;
    }
    public double findLevel(int label){
        double level = 0;
        while(label > 0){
            label = label/2;
            level++;
        }
        return level;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.pathInZigZagTree(14));
        System.out.println(sol.pathInZigZagTree(13));
        System.out.println(sol.pathInZigZagTree(12));
        System.out.println(sol.pathInZigZagTree(11));
        System.out.println(sol.pathInZigZagTree(7));
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
