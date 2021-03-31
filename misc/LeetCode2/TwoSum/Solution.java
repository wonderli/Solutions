import java.util.*;
public class Solution{
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) return null;
        int len = numbers.length;
        Pair p[] = new Pair[len];
        for(int i = 0; i < len; i++){
            p[i] = new Pair(i+1, numbers[i]);
        }
        Arrays.sort(p);
        int i = 0;
        int j = len - 1;
        int ret[] = new int[2];
        while(i < j){
            int a = p[i].second;
            int b = p[j].second;
            if((a + b) == target){
                ret[0] = (p[i].first < p[j].first ? p[i].first : p[j].first);
                ret[1] = (p[i].first < p[j].first ? p[j].first : p[i].first); 
                break;
            }else if( (a + b) < target){
                i++;
            }else j--;
        }
        return ret;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(sol.twoSum(num, target)));
    }
}
class Pair implements Comparable{
    int first;
    int second;
    public Pair(int a, int b){
        first = a;
        second = b;
    }
    public int compareTo(Object o){
        Pair p = (Pair)o;
        return this.second - p.second;
    }
}
