import java.util.*;
public class Solution{
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int[] count = new int[26];
        for(char t : tasks){
            count[t - 'A']++;
        }
        Arrays.sort(count);
        int maxFrequence = count[25];
        int idleTime = (maxFrequence - 1) * n;
        for(int i = count.length - 2; i >= 0 && idleTime > 0; i--){
            idleTime -= Math.min(maxFrequence - 1, count[i]);
        }
        idleTime = Math.max(0, idleTime);
        return idleTime + tasks.length;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
