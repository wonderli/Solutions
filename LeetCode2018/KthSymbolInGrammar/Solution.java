import java.util.*;
public class Solution{
    public int kthGrammar(int N, int K) {
        if(N == 1) return 0;
        String curr = "0";
        String res = helper(2, N, curr);
        //System.out.println(res);
        return res.charAt(K - 1) - '0';
    }
    public String helper(int index, int N, String prev){
        if(index == N + 1) return prev;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < prev.length(); i++){
            if(prev.charAt(i) == '0'){
                sb.append('0');
                sb.append('1');
            } else if(prev.charAt(i) == '1'){
                sb.append('1');
                sb.append('0');
            }
        }
        return helper(index + 1, N, sb.toString());
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.kthGrammar(4, 5));
		sol.helper(4);
    }
    private int helper(int N){
          if (N == 0) {
              return 0;
          }
          int next = helper(N - 1);
          int oppo = ~ next;
		  int mask = (int) Math.pow(2, N) - 1;
		  System.out.println(Integer.toBinaryString(oppo  & mask) + " oppo " +Integer.toBinaryString(next));
		  next <<= ((int) Math.pow(2, N));
		  int res = next | (oppo  & mask);
		  System.out.println(Integer.toBinaryString(res));
          return res;
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
