import java.util.*;
public class Solution3{
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if(n == 0) return ret;
        Set<String> set = new HashSet<>();
        set.add("()");
        for(int i = 1; i < n; i ++){
            Set<String> tmp = new HashSet<>();
            for(String curr : set){
                String a = curr + "()";
                String b = "()" + curr;
                tmp.add(a);
                tmp.add(b);
                for(int j = 0; j < curr.length() - 1 ; j++){
                    if(curr.charAt(j) == '(' && curr.charAt(j+1) == ')'){
                        String c = curr.substring(0, j+1) + "()" + curr.substring(j+1);
                        tmp.add(c);
                        String d = curr.substring(0, j+1) + ")(" + curr.substring(j+1);
                        tmp.add(d);
                    }
                }
            }
            set = tmp;
        }
        ret.addAll(set);
        return ret;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
        List<String> ret = sol.generateParenthesis(3);
        System.out.println(ret);
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
