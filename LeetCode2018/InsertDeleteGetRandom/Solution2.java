import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class RandomizedSet {

    private Set<Integer> set = new HashSet<>();
    private List<Integer> list = new ArrayList<>();
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }
        set.add(val);
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            list.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int next = rand.nextInt(list.size());
        return list.get(next%list.size());
    }
}
