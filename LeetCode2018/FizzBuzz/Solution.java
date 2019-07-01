import java.util.*;
public class Solution{
    public List<String> fizzBuzz(int n) {
        if(n == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }else if(i % 3 == 0){
                result.add("Fizz");
            }else if(i % 5 == 0){
                result.add("Buzz");
            }else{
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
