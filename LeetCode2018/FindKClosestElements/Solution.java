import java.util.*;
class Solution{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        int closest = search(arr, x);
        int r = closest;
        int l = closest;
        while(r - l +1 < k && l > 0 && r < arr.length - 1){
            if(Math.abs(arr[l -1] - x) <= Math.abs(arr[r + 1] - x)){
                l--;
            }else {
                r++;
            }
        }
        while(r - l + 1 < k){
            if(l > 0){
                l--;
            }else {
                r++;
            }
        }
        while(l <= r){
            ret.add(arr[l]);
            l++;
        }
        return ret;
    }
    public int search(int[] arr, int x){
        int l = 0;
        int r = arr.length - 1;
        int closest = -1;
        int minDiff= Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(Math.abs(arr[mid] - x) < minDiff){
                minDiff = Math.abs(arr[mid] - x);
                closest = mid;
            } 
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] > x){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return closest;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
