import java.util.*;
public class Solution{
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int i = -1; 
        int j = 0;
        while(j < len){
            if(A[j] == elem){
                j++;
            }else{
                i++;
                A[i] = A[j];
                j++;
            }
        }
        return i + 1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {1, 2, 3, 3, 4, 5};
        int elem = 3;
        System.out.println(Arrays.toString(A));
        System.out.println(sol.removeElement(A, elem));
        System.out.println(Arrays.toString(A));

    }
}
