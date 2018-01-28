import java.util.*;
public class Solution{

    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();            
        int len = nums.length;
        for(int i = 0; i < len;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        List<Integer>[] frequencyCount = new ArrayList[len + 1];
        for(int i : map.keySet()){
            int frequency = map.get(i);
            System.out.println(frequency);
            if(frequencyCount[frequency] == null){
                frequencyCount[frequency] = new ArrayList<Integer>();
            }
            frequencyCount[frequency].add(i);
        }
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = len, j = 0; k > 0; k--){
            while(frequencyCount[i] == null || frequencyCount[i].size() == j){
                i--;
                j = 0;
            }
            ret.add(frequencyCount[i].get(j++));
        }
        return ret;

    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums = {6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        System.out.println(sol.topKFrequent(nums, 2));
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
