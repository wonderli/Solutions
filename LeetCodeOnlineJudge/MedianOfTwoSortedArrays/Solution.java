//Median of Two Sorted Arrays 
//
//There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
import java.util.*;
public class Solution{
//    public double findMedianSortedArrays(int A[], int B[]) {
//        int m = A.length;
//        int n = B.length;
//        int mid = (m + n)/2;
//        int start = 0;
//        int end = m - 1;
//        int i = 0;
//        int j = 0;
//        int median = 0;
//        while(start <= end){
//            i = (start + end)/2;
//            j = mid - i;
//            if(get(B, j - 1) <= get(A, i) && get(A, i) <= get(B, j)){
//                median = get(A,i);
//                break;
//            }else if(get(A, i) <= get(B, j - 1)){
//                start = i + 1;
//                i = (start + end)/2;
//                j = mid - i;
//            }else if(get(A, i) > get(B, j)){
//                end = i - 1;
//                i = (start + end)/2;
//                j = mid - i;
//            }
//        }
//        if(start <= end){
//            if((m + n) %2 == 0){
//                int other = Math.max(get(A, i-1), get(B, j-1));
//                return (median+other) * 0.5;
//            }else{
//                return (double)median;
//            }
//        }
//        else{
//            return findMedianSortedArrays(B, A);
//        }
//    }
//    public int get(int A[], int i){
//        if(i < 0){
//            return Integer.MIN_VALUE;
//        }else if(i >= A.length){
//            return Integer.MAX_VALUE;
//        }else{
//            return A[i];
//        }
//    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int A[] = {1, 12, 15, 26, 38};
        //int B[] = {2, 13, 17, 30, 45};
        int A[] = {1,1};
        int B[] = {1,1};
        System.out.println(sol.findMedianSortedArrays(A, B));
    }
}
