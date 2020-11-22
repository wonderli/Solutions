import java.util.*;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] ==b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });
        
        List<int[]> res = new LinkedList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        int n = people.length;
        return res.toArray(new int[n][2]);
    }
}
