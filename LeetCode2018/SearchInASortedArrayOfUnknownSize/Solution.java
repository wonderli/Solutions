/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    Integer res = -1;
    public int search(ArrayReader reader, int target) {
        int r = 1;
        while(reader.get(r) < target){
            r= r<<1;
        }
        helper(reader, 0, r, target);
        return res;
    }
    public void helper(ArrayReader reader, int left, int right, int target){
    
        if(left > right){
            return;
        }
        int mid = left + (right - left)/2;

        if(reader.get(mid) == target){
            res = mid;
        }else if(reader.get(mid) < target){
            helper(reader, mid+1, right, target);
            
        }
        else if(reader.get(mid) > target){
            helper(reader, left, mid-1, target);
        }      
        
    }
}