//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
public class Solution{
    public int[] searchRange(int[] A, int target) {
        int ret[] = {-1, - 1};
        if(A == null || A.length == 0){
            return ret;
        }
        int len = A.length - 1;
        int l = 0;
        int r = len; 
        while(l < r){
            int mid = (l + r) /2;
            if(A[mid] < target) l = mid + 1;
            else r = mid;
        }
        if(A[r] == target) ret[0] = r; 
        else return ret;
        l = 0;
        r = len;
        while(l < r){
            int mid = (l + r)/2;
            if(A[mid] < target + 1) l = mid + 1;
            else r = mid;
        }
        if(A[r] > target) ret[1] = r - 1;
        else ret[1] = r;
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
