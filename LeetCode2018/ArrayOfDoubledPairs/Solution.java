import java.util.*;
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : arr){
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        Integer[] B = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            B[i] = arr[i];
        }
        Arrays.sort(B, (a, b) -> (Math.abs(a) - Math.abs(b)));
        int count = arr.length;
        for(int e : B){
            if(map.get(e) == 0) continue;
            if(map.getOrDefault(2 * e, 0) <= 0) return false;
            map.put(e, map.get(e) - 1);
            map.put(2 * e, map.get(2 * e) - 1);
            
        }
       
        return true;
        
    }
}