import java.util.*;
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++){
            for(int[] u : updates){
                int start = u[0];
                int end = u[1];
                int v = u[2];
                if(start <= i && i <= end){
                    arr[i] += v;
                }
            }
        }
        return arr;
    }
}