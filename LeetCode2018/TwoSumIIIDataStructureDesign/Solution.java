import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TwoSum {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int b = value - entry.getKey();
            if(b != entry.getKey()){
                if(map.containsKey(b)){
                    return true;
                }
            }else {
                if(entry.getValue() > 1){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
