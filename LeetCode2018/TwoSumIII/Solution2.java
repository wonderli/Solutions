import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        TwoSum ts = new TwoSum();
        ts.add(3);
        ts.add(2);
        ts.add(1);
        //System.out.println(ts.find(2));
        //System.out.println(ts.find(3));
        System.out.println(ts.find(4));
        //System.out.println(ts.find(5));
        //System.out.println(ts.find(6));
    }
}


class TwoSum {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)){
            int n = map.get(number);
            map.put(number, n+1);
        }else{
            list.add(number);
            map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        boolean found = false;
        for(int i = 0; i < list.size(); i++){
            int a = list.get(i);
            int b = value - list.get(i);
            
            if((a == b && map.get(b) > 1) ||(a != b && map.containsKey(b))){
                return true;
            }
        }
        return found;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

