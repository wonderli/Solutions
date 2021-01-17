import java.util.*;
public class Solution{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n : nums){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}