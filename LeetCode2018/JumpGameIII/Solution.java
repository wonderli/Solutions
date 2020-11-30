class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length) return false;
        if(arr[start] == 0) return true;
        if(arr[start] < 0) return false;
        int v = arr[start];
        arr[start] = - arr[start];
        
        return canReach(arr, start - v) || canReach(arr, start + v);
    }
}