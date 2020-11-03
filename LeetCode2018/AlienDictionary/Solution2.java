import java.util.*;
public class Solution2{
	
	
	   public String alienOrder(String[] words) {
	        if(words == null || words.length == 0) return "";
	        Map<Character, Integer> inDegree = new HashMap<>();
	        Map<Character, List<Character>> map = new HashMap<>();
	        for(String w : words){
	            for(char c : w.toCharArray()){
	                inDegree.put(c, 0);
	                map.put(c, new ArrayList<>());
	            }
	        }

	        for(int i = 0; i < words.length - 1; i++){
	            String w1 = words[i];
	            String w2 = words[i + 1];
	            // Check that word2 is not a prefix of word1.
	            if (w1.length() > w2.length() && w1.startsWith(w2)) {
	            return "";
	            }
	            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++){
	                char parent = w1.charAt(j);
	                char child = w2.charAt(j);
	                if(parent != child){
	                    inDegree.put(child, inDegree.get(child)+1);
	                    map.get(parent).add(child);
	                    break;
	                }
	            }
	        }
	        StringBuilder res = new StringBuilder();
	        while(!inDegree.isEmpty()){
	            boolean flag = false;
	            for(Character c : inDegree.keySet()){
	                if(inDegree.get(c) == 0){
	                    flag = true;
	                    res.append(c);
	                    List<Character> children = map.get(c);
	                    for(char e : children){
	                        inDegree.put(e, inDegree.get(e)-1);
	                    }
	                    inDegree.remove(c);
	                    break;
	                }
	            }
	            if(flag == false){
	                return "";
	            }
	        }
	        return res.toString();
	    }
	
	
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
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
