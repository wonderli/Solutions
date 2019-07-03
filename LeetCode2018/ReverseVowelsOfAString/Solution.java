import java.util.*;
public class Solution{
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        if(s == null || s.length() == 0) return s;

        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while(i < j){
            while(i < j && !set.contains(arr[i])){
                i++;
            }
            while(i < j && !set.contains(arr[j])){
                j--;
            }
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.reverseVowels("hello"));
        System.out.println(sol.reverseVowels("leetcode"));
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
