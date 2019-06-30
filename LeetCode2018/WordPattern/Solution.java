import java.util.*;
public class Solution{
    public boolean wordPattern(String pattern, String str) {
        String[] sArr = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        if(sArr.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < sArr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(sArr[i])){
                    return false;
                }
            }else{
                if(map.containsValue(sArr[i])){
                    return false;
                }
                map.put(c, sArr[i]);
            }
        }
        return true;
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
