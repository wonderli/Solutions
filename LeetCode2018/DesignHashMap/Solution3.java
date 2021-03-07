import java.util.*;
class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class MyHashMap {
    int keySpace;
    List<Bucket> hashTable;
    /** Initialize your data structure here. */
    public MyHashMap() {
        keySpace = 2069;
        hashTable = new ArrayList<Bucket>();
        for(int i = 0; i < keySpace; i++){
            hashTable.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % keySpace;
        hashTable.get(hashKey).update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key % keySpace;
        return hashTable.get(hashKey).get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % keySpace;
        hashTable.get(hashKey).remove(key);
    }
}
class Pair<U, V> {
    public U first;
    public V second;
    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

class Bucket{
    private List<Pair<Integer, Integer>> bucket;
    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public Integer get(Integer key){
        for(Pair<Integer, Integer> p : bucket){
            if(p.first.equals(key)){
                return p.second;
            }            
        }
        return -1;
    }
    
    public void update(Integer key, Integer value){
        boolean found = false;
        for(Pair<Integer, Integer> p : bucket){
            if(p.first.equals(key)){
                p.second = value;
                found = true;
            }
        }
        if(!found){
            bucket.add(new Pair<Integer, Integer>(key, value));
        }
    }
    
    public void remove(Integer key){
        for(Pair<Integer, Integer> p : bucket){
            if(p.first.equals(key)){
                bucket.remove(p);
                break;
            }
        }
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
