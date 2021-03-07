import java.util.*;
class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class HitCounter {

    
    private class Pair{
        int timestamp;
        int count;
        public Pair(int timestamp, int count){
            this.timestamp = timestamp;
            this.count = count;
        }
    }
    private Deque<Pair> queue;
    int total;
    /** Initialize your data structure here. */
    public HitCounter() {
        this.total = 0;
        this.queue  = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(queue.isEmpty() || queue.peekLast().timestamp != timestamp){
            queue.addLast(new Pair(timestamp, 1));
        }else{
            Pair p = queue.pollLast();
            p.count++;
            queue.addLast(p);
        }
        total++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty()){
            int diff = timestamp - queue.peekFirst().timestamp;
            if(diff >= 300){
                Pair p = queue.pollFirst();
                total = total - p.count;
            }else{
                break;
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
