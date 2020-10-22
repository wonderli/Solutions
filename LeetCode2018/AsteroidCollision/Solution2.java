import java.util.*;
public class Solution2{
    public int[] asteroidCollision(int[] asteroids){
        int currentLen = asteroids.length;
        while(currentLen > 0){
            int newLen = helper(asteroids, currentLen);
            if(currentLen ==newLen){
                break;
            }
            currentLen = newLen;
        }
        return Arrays.copyOf(asteroids, currentLen);
    }
    private int helper(int[] arr, int len){
        int curr = 0;
        for(int i=1;i <len; i++){
            if(curr < 0){
                curr++;
                arr[curr] = arr[i];
                continue;
            }
            // apart
            if(arr[curr] < 0 && arr[i] > 0){
                curr++;
                arr[curr] = arr[i];
            }else if(arr[curr] * arr[i] > 0){
                curr++;
                arr[curr] = arr[i];
            }else {
                if(arr[curr] == arr[i]  * -1){
                    curr--;
                }else if(arr[curr] > arr[i] * -1){

                }else if(arr[curr] < arr[i] * -1){
                    arr[curr] = arr[i];
                }
            }
        }
        return curr+1;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
