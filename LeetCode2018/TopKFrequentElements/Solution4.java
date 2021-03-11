import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums){
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        int n = map.size();
        int[] unique = new int[n];
        int i = 0;
        for(int e : map.keySet()){
            unique[i] = e;
            i++;
        }
        
        select(unique, n - k, map);
        int[] result =new int[k];
        i = 0;
        for(int j = n-1; j >= n - k ; j--){
            result[i] = unique[j];
            i++;
        }
        // System.out.println(Arrays.toString(unique));
        return result;
    }
    private void select(int[] unique, int target, Map<Integer, Integer> map){
        int l = 0;
        int r = unique.length - 1;
        while(l < r){
            int mid = partition(unique, l, r, map);
            if(mid == target){
                break;
            }else if(mid < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
    }
    private int partition(int[] unique, int l, int r, Map<Integer, Integer> map){
        int pivot = map.get(unique[r]);
        int i = l - 1;
        for(int j = l; j < r; j++){
            int curr = map.get(unique[j]);
            if(curr < pivot){
                swap(unique, i+1, j);
                i++;
            }
        }
        swap(unique, i+1, r);
        return i+1;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}