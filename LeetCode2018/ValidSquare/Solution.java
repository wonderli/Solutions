import java.util.*;
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        
     int p01 = dist(p[0], p[1]);
    int p13 = dist(p[1], p[3]);
    int p32 = dist(p[3], p[2]);
        int p20 = dist(p[2], p[0]);
        int p03= dist(p[0], p[3]);
        int p12 = dist(p[1], p[2]);
        return p01 != 0 && p01 == p13 && p13 == p32 && p32 == p20 && p03 == p12;
    

    }
    private int dist(int[] a, int[] b){
        return (b[1] - a[1]) * (b[1] -a[1]) + (b[0] - a[0]) * (b[0] - a[0]);
    }
}