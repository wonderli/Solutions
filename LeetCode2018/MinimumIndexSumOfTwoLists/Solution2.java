import java.util.*;
public class Solution2{
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        List<String> ret = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                int sum = i + map.get(list2[i]);
                if(sum < min){
                    min = sum;
                    ret.clear();
                    ret.add(list2[i]);
                }else if(sum == min){
                    ret.add(list2[i]);
                }
            }
        }
        return ret.toArray(new String[0]);
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
