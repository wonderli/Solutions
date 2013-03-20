public class Solution{
    public static int search(int A[], int key){
        if(A.length < 1) return -1;
        int n = A.length;
        int left = 0;
        int right = n - 1;
        if(n == 1) return A[0] == key ? 0 : -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(A[mid] == key) return mid;
            int rm = A[mid+1];
            if(rm < A[mid]){
                if(key > A[right] && key < A[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(key > A[left] && key < A[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return A[left] == key ? left : -1;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {1, 2, 3, 10, 9, 8, 7, 6, 5, 4};
        System.out.println(search(A, 10));
    }
}
