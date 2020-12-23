import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                int j = stack.pop();
                map.put(j, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
