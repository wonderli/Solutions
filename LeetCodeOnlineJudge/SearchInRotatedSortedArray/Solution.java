public class Solution{
    public int search(int[] A, int target) {
        if(A.length == 0) return -1;
        int len = A.length;
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(A[mid] == target) return mid;
            else if(A[l] <= A[mid]){
                if(target >= A[l] && target <= A[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target >= A[mid] && target <= A[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
