import java.util.*;
public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int avaiableForDrop = n - k;
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && nums[i] < deque.peekLast() && avaiableForDrop > 0){
                deque.pollLast();
                avaiableForDrop--;
            }
            deque.addLast(nums[i]);
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = deque.pollFirst();
        }
        return result;
    }
}