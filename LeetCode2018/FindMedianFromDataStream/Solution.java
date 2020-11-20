import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class MedianFinder {

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    /** initialize your data structure here. */
    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.peek());
        low.poll();
        if(low.size() < high.size()){
            low.add(high.peek());
            high.poll();
        }
    }
    
    public double findMedian() {
        return low.size() > high.size() ? low.peek() : (double)(low.peek() + high.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
