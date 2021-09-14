import java.util.*;
class Solution {
    public int maxNumberOfBalloons(String text) {
        // b a l o n;
        int[] count = new int[5];
        for(char c : text.toCharArray()){
            if(c == 'b'){
                count[0]++;
            }else if(c == 'a'){
                count[1]++;
            }else if(c == 'l'){
                count[2]++;
            }else if(c == 'o'){
                count[3]++;
            }else if(c == 'n'){
                count[4]++;
            }
        }
        count[2] = count[2]/2;
        count[3] = count[3]/2;
        return Math.min(count[0], Math.min(count[1], Math.min(count[2], Math.min(count[3], count[4]))));
    }
}
