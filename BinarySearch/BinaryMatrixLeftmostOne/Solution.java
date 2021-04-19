import java.util.*;
/**
You are given a two-dimensional list of integers matrix which contains 1s and 0s. Given that each row is sorted in ascending order with 0s coming before 1s, return the leftmost column index with the value of 1. If there's no row with a 1, return -1.

Can you solve it faster than \mathcal{O}(nm)O(nm).

Constraints

n, m ≤ 250 where n and m are the number of rows and columns in matrix
Example 1
Input
matrix = [
    [0, 0, 0, 0],
    [0, 0, 1, 1],
    [0, 0, 0, 1],
    [0, 1, 1, 1]
]
Output
1
Explanation
The last row contains the leftmost column with a one at index 1.
*/
class Solution {
    public int solve(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return -1;
        int n = matrix[0].length;
        if(n ==0) return -1;
        int i = 0;
        int j = n-1;
        int result = -1;
        while(i < m && j >= 0){
            if(matrix[i][j] == 1){
                result = j;
                j--;
            }else{
                i++;
            }
        }
        return result;
        
    }
}