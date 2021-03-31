//Pairs
//
//Given N numbers [N<=10^5], count the total pairs of numbers that have a difference of K. [K>0 and K<1e9]
//
//Input Format:
//
//1st line contains N & K (integers).
//2nd line contains N numbers of the set. All the N numbers are assured to be distinct.
//
//Output Format:
//
//One integer saying the no of pairs of numbers that have a diff K.
//
//Sample Input #00:
//
//5 2
//1 5 3 4 2
//
//Sample Output #00:
//
//3
//
//Sample Input #01:
//
//10 1
//363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793 
//
//Sample Output #01:
//
//0
//https://www.hackerrank.com/challenges/pairs
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int solve(int a[], int n, int k){
        Arrays.sort(a);
        int count = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(a[j] - a[i] == k){
                    count++;
                    break;
                }else if(a[j] - a[i] < k){
                    continue;
                }else if(a[j] - a[i] > k){
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        int i = 0;
        while(i < n){
            a[i] = sc.nextInt();
            i++;
        }
        System.out.println(solve(a, n, k));
    }
}
