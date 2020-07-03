import java.util.*;
public class Solution2{
    public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0) return res;
		String[] pad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        int index = 0;
        while(index < digits.length()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                String currPad = pad[Character.getNumericValue(digits.charAt(index))];
                for(char c : currPad.toCharArray()){
                    queue.add(s + c);
                }
            }
            index++;

        }
        res.addAll(queue);
        return res;
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
        System.out.println(sol.letterCombinations("23"));
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
