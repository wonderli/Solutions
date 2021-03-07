import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class MyHashSet {
    List<Integer>[] set;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.set = new List[1000];
    }

    public void add(int key) {
        if (!contains(key)) {
            int index = key % 1000;
            if (set[index] == null) {
                set[index] = new ArrayList<Integer>();
            }
            set[index].add(key);
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int index = key % 1000;
            set[index].remove(Integer.valueOf(key));
        }
    }


    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key % 1000;
        if (set[index] == null) {
            return false;
        }
        return set[index].contains(key);
    }
}
