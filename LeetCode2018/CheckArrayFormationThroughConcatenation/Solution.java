import java.util.*;
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < pieces.length; i++){
            int first = pieces[i][0];
            map.put(first, i);
        }
        int i = 0;
        int n = arr.length;
        while(i < n){
            if(!map.containsKey(arr[i])){
                return false;
            }
            int index = map.get(arr[i]);
            int[] p = pieces[index];
            for(int j = 0; j < p.length; j++){
                if(arr[i] == p[j]){
                    i++;
                }else{
                    return false;
                }
            }
        }
        return true;
        
    }
}
