import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class AllOne {

    class Bucket {
        int v;
        Set<String> set;
        Bucket prev;
        Bucket next;
        public Bucket(int v){
            this.v = v;
            set = new HashSet<>();
        }
    }
    
    Bucket head;
    Bucket tail;
    Map<String, Integer> keyToValue;
    Map<Integer, Bucket> valueToBucket;
    
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.next = tail;
        tail.prev = head;
        keyToValue = new HashMap<>();
        valueToBucket = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int value = keyToValue.getOrDefault(key, 0) + 1;
        Bucket bucket = valueToBucket.get(value);
        if(bucket == null){
            Bucket newBucket = insertBucketByPre(value, valueToBucket.get(value - 1));
            newBucket.set.add(key);
        }else{
            bucket.set.add(key);
        }
        removeKeyFromBucket(key, valueToBucket.get(value - 1));
        keyToValue.put(key, value);
    }
    
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!keyToValue.containsKey(key)) return;
        
        int value = keyToValue.get(key) - 1;
        Bucket bucket = valueToBucket.get(value);
        if(bucket == null && value > 0){
            Bucket newBucket = insertBucketByNext(value, valueToBucket.get(value + 1));
            newBucket.set.add(key);
        }else if(value > 0){
            bucket.set.add(key);
        }
        removeKeyFromBucket(key, valueToBucket.get(value+1));
        if(value > 0){
            keyToValue.put(key, value);
        }else{
            keyToValue.remove(key);
        }
    }
    
    private Bucket insertBucketByPre(int value, Bucket prevBucket){
        if(prevBucket == null) prevBucket = head;
        Bucket bucket = new Bucket(value);
        Bucket next = prevBucket.next;
        prevBucket.next = bucket;
        bucket.next = next;
        bucket.prev = prevBucket;
        next.prev = bucket;
        valueToBucket.put(value, bucket);
        return bucket;
    }
    
    private Bucket insertBucketByNext(int value, Bucket nextBucket){
        if(nextBucket == null) nextBucket = tail;
        Bucket bucket =new Bucket(value);
        Bucket prev = nextBucket.prev;
        prev.next = bucket;
        bucket.prev = prev;
        bucket.next = nextBucket;
        nextBucket.prev = bucket;
        valueToBucket.put(value, bucket);
        return bucket;
    }
    
    private void removeKeyFromBucket(String key, Bucket bucket){
        if(bucket == null) return;
        bucket.set.remove(key);
        if(bucket.set.isEmpty()){
            bucket.prev.next = bucket.next;
            bucket.next.prev = bucket.prev;
            valueToBucket.remove(bucket.v);
            bucket = null;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.set.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.set.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
