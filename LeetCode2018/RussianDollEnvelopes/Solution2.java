import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        
        List<Integer> piles = new ArrayList<>();
        for(int[] e : envelopes){
            int curr = e[1];
            int index = Collections.binarySearch(piles, curr);
            if(index < 0){
                index = ~index;
            }
            if(index == piles.size()){
                piles.add(curr);
            }else{
                piles.set(index, curr);
            }
        }
        return piles.size();
    }
}
