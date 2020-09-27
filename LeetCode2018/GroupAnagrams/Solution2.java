import java.util.*;
public class Solution2{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String e : strs){
            String s = sort(e);
            if(map.containsKey(s)){
                List<String> l = map.get(s);
                l.add(e);
            }else{
                List<String> l = new ArrayList<>();
                l.add(e);
                map.put(s, l);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        ret.addAll(map.values());
        return ret;
    }
    public String sort(String s){
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        StringBuilder sb = new StringBuilder();
        sb.append(sArr);
        return sb.toString();
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
