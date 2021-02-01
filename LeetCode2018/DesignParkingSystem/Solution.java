import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ParkingSystem {

    int BIG = 0;
    int MEDIUM = 1;
    int SMALL = 2;
    int[] capacity;
    public ParkingSystem(int big, int medium, int small) {
        capacity = new int[3];
        capacity[BIG] = big;
        capacity[MEDIUM] = medium;
        capacity[SMALL] = small;
    }
    
    public boolean addCar(int carType) {
        if(capacity[carType - 1] - 1 >= 0){
            capacity[carType - 1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */