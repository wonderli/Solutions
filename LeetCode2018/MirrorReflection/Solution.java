import java.util.*;
public class Solution{
    public int mirrorReflection(int p, int q) {
        int x = 0, y = 0;
        while (true) {
            y += q;

            // If left then right. If right then left.
            if (x == 0) x = p;
            else x = 0;

            // If we hited any corner.
            if (y % p == 0) {
                if (y / p % 2 == 0) return 0;
                else if (x == p) return 1;
                else return 2;
            }
        }
    }
    public static void main(String args[]){

        Solution sol = new Solution();
    }
}
