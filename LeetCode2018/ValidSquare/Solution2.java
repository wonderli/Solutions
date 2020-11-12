import java.util.*;
class Solution2{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> s = new HashSet<>();
        if (isSame(p1,p2) || isSame(p1,p3) || isSame(p1,p4) || isSame(p2,p3) || isSame(p3,p4) || isSame(p2,p4)) {
            return false;
        } 
        
        s.add(dist(p1, p2));
        s.add(dist(p1, p3));
        s.add(dist(p1, p4));
        s.add(dist(p2, p3));
        s.add(dist(p2, p4));
        s.add(dist(p3, p4));
        return s.size() == 2;
    }
    
    private boolean isSame(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }
    
    private int dist(int[] a, int[] b){
        return (b[1] - a[1]) * (b[1] -a[1]) + (b[0] - a[0]) * (b[0] - a[0]);
    }
}