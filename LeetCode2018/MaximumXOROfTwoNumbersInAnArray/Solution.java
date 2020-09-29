import java.util.*;
public class Solution{
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int num : nums){
            maxNum = Math.max(num, maxNum);
        }
        int len = (Integer.toBinaryString(maxNum)).length();
        int n = nums.length;
        int bitmask = 1 << len;
        String[] strNums = new String[n];
        for(int i = 0; i < n; i++){
            strNums[i] = Integer.toBinaryString(bitmask|nums[i]).substring(1);
        }
        TrieNode root = new TrieNode();
        int maxXor = 0;
        for(String num : strNums){
            TrieNode curr = root;
            TrieNode xorNode = root;
            int currXor = 0;
            for(char bit : num.toCharArray()){
                if(!curr.children.containsKey(bit)){
                    TrieNode t = new TrieNode();
                    curr.children.put(bit, t);
                }
                curr = curr.children.get(bit);
                char toggledBit = bit == '1' ? '0' : '1';
                if(xorNode.children.containsKey(toggledBit)){
                    currXor = (currXor << 1) | 1;
                    xorNode = xorNode.children.get(toggledBit);
                }else {
                    currXor = currXor << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }
            maxXor = Math.max(maxXor, currXor);

        }
        return maxXor;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
}
