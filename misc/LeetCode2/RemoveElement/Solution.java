import java.util.*;
public class Solution{
    public int removeElement(int[] A, int elem) {
       if(A == null || A.length == 0) return 0; 
       int len = A.length;
       int i = -1;
       int j = 0;
       for(j = 0; j < len; j++){
           if(A[j] != elem){
               i += 1;
               int tmp = A[i];
               A[i] = A[j];
               A[j] = tmp;
           }
       }
       return i+1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {2};
        int elem = 3;
        System.out.println(sol.removeElement(A, elem));
    }
}
