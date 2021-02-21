import java.util.*;
class Solution {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while(Y > X){
            if(Y % 2 == 1){
                Y++;
            }else{
                Y /= 2;
            }
            count++;
        }
        return count + (X - Y); 
    }
}
