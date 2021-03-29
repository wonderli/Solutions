import java.util.*;
class PhoneDirectory {
    Queue<Integer> queue;
    Set<Integer> used;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.add(i);
       }
        used = new HashSet<>();
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.isEmpty()) {
            return -1;
        }
        int next = queue.poll();
        used.add(next);
        return next;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (!used.contains(number)) return;
        used.remove(number);
        queue.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
