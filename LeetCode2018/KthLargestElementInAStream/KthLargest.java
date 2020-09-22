import java.util.*;
public class KthLargest{
    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for(int n : nums){
            add(n);
        }
    }

    public int add(int val) {
        if(queue.size() < k){
            queue.offer(val);
        }else if(queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String args[]){
        int[] a = {4, 5, 8, 2};
        KthLargest sol = new KthLargest(3, a);
        System.out.println(sol.add(3));
        System.out.println(sol.add(5));
        System.out.println(sol.add(10));
        System.out.println(sol.add(9));
        System.out.println(sol.add(4));
    }
}

