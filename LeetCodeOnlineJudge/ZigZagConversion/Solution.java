// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
import java.util.*;
public class Solution{
    public String convert(String s, int nRows) {
        if(s.length() < nRows) return s;
        int len = s.length();
        char A[][] = new char[len][len];
        char str[] = s.toCharArray();
        int row = len;
        int col = len;
        for(int m = 0; m < row; m++){
            for(int n = 0; n < col; n++){
                A[m][n] = ' ';
            }
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while(k < len){
            for(i = 0; i < nRows && k < len; i++){
                A[i][j] = str[k];
                k++;
            }
            j++;
            int pos = j;
            for(i = nRows - 2; i > 0 && pos - j < nRows-1 && k < len; i--){
                A[i][j] = str[k];
                j++;
                k++;
            }
        }
        //for(int l = 0; l < A.length; l++){
        //    System.out.println(Arrays.toString(A[l]));
        //}
        StringBuilder sb = new StringBuilder();
        for(int m = 0; m < row; m++){
            for(int n = 0; n < col; n++){
                if(A[m][n] != ' '){
                    sb.append(A[m][n]);
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "paypalishiring";
        int row = 4;
        System.out.println(sol.convert(s, row));
    }
}

