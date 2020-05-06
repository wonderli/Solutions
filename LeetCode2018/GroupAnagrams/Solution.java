import java.util.*;
public class Solution{
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String newStr = new String(cs);
            List<Integer> list = map.getOrDefault(newStr, new ArrayList<>());
            list.add(i);
            map.put(newStr, list);
        }
        for(String key : map.keySet()){
            List<String> curr = new ArrayList<>();
            List<Integer> indexes = map.get(key);
            for(int index : indexes){
                curr.add(strs[index]);
            }
            res.add(curr);
        }
        return res;
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
