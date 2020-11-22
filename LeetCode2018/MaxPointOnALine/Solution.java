import java.util.*;
class Solution {
    public int maxPoints(int[][] points) {
        if(points == null) return 0;
        if(points.length <= 2) return points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < points.length; i++){
            map.clear();
            int overlap = 0;
            int max = 0;
            for(int j = i+1; j <points.length; j++){
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if(x == 0 && y == 0){
                    overlap++;
                    continue;
                }
                
                int gcd = gcd(x, y);
                if(gcd != 0){
                    x = x/gcd;
                    y = y/gcd;
                }
                if(map.containsKey(x)){
                    if(map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }
                }else{
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max+overlap+1);
        }
        return res;
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
