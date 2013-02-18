// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
// Your algorithm should run in O
import java.util.*;
public class Solution{
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int len = num.length;
        for(int i = 0; i < len; i++){
            set.add(num[i]);
        }
        int max = 0;
        int currLen = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            maxValue = maxValue > num[i] ? maxValue : num[i];
        }
        int last = 0;
        while(!set.isEmpty()){
            Iterator<Integer> it = set.iterator();
            int curr = it.next().intValue();
            last = curr;
            currLen = 1;
            while(set.contains(curr+1)){
                set.remove(curr);
                curr++;
                currLen++;
            }
            curr = last;
            while(set.contains(curr-1)){
                set.remove(curr);
                curr--;
                currLen++;
            }
            set.remove(last);
            max = currLen > max ? currLen : max;
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {-1, -2, 0, 1};
        System.out.println(sol.longestConsecutive(num));
    }
}
