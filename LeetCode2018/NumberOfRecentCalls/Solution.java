import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        int head = queue.isEmpty() ? 0 : queue.peek();
        queue.add(t);
        if(t - 3000 > head){
            while(!queue.isEmpty() && t -  3000 > queue.peek()){
                queue.poll();
            }
        }
        return queue.size();
    }
}
