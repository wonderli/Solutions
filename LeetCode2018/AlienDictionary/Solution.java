import java.util.*;
public class Solution{
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j))+1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c : counts.keySet()){
            if(counts.get(c).equals(0)){
                queue.add(c);
            }
        }
        while(!queue.isEmpty()){
            Character c = queue.remove();
            sb.append(c);
            for(Character next : adjList.get(c)){
                counts.put(next, counts.get(next) - 1);
                if(counts.get(next).equals(0)){
                    queue.add(next);
                }
            }
        }
        if(sb.length() < counts.size()){
            return "";
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
