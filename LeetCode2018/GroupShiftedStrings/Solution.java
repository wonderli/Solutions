import java.util.*;
public class Solution{
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
    public String getKey(String s){
        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < sArr.length; i++){
            int diff = sArr[i] - sArr[i-1];
            if(diff < 0){
                diff = diff + 26;
            }
            sb.append(diff);
            sb.append(",");
        }
        return sb.toString();
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
