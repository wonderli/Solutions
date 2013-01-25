//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//
//Write a function to determine if a given target is in the array.
public class Solution{
    public boolean search(int[] A, int target) {
        int len = A.length;
        if(len == 0) return false;
        for(int i = 0; i < len; i++){
            if(A[i] == target) return true;
        }
        return false;
    }
    
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
