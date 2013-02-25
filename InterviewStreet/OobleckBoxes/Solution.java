import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int solve(int target, int base){
        int size = 0;
        int cand = 1;
        while(cand <= target){
            cand *= base;
            size++;
        }
        int candidates[] = new int[size];
        candidates[0] = 1;
        for(int i = 1; i < size; i++){
            candidates[i] = candidates[i - 1] * base;
        }
        int res[] = new int[1];
        res[0] = 0;
        helper(target, 0, candidates, 0, res);
        return res[0]%1000000007;
    }
    public static void helper(int target, int sum, int candidates[], int index, int res[]){
        if((index >= candidates.length && sum < target)|| sum > target){
            return;
        }
        
        if(sum == target){
            res[0]++;
            return;
        }
        for(int i = 0; sum + i * candidates[index] <= target; i++){
            helper(target, sum + i * candidates[index], candidates, index + 1, res);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(solve(N, M));
    }
}
