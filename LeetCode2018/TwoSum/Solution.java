import java.util.*;
public class Solution{
    public int[] twoSum(int[] nums, int target) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(new Pair(i, nums[i]));
        }
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2){
                return p1.value - p2.value;
            }
        });
        int i = 0;
        int j = list.size() - 1;
        int[] result = new int[2];
        while(i < j){
            int left = list.get(i).value;
            int right = list.get(j).value;
            if(left + right < target){
                i++;
            }else if(left + right > target){
                j--;
            }else if(left + right == target){
                result[0] = list.get(i).index;
                result[1] = list.get(j).index;
                break;
            }
        }
        return result;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] s = {2, 7, 11, 15};
        System.out.println(Arrays.toString(sol.twoSum(s, 9)));
    }
}
class Pair {
    public int index;
    public int value;
    public Pair(int index, int value){
        this.index = index;
        this.value = value;
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
