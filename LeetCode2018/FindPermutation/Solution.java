class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] arr = new int[n+1];
        for(int i = 0; i <= n; i++){
            arr[i] = i + 1;
        }
        for(int j = 0; j < n; j++){
            if(s.charAt(j) == 'D'){
                int l = j;
                while(j < n && s.charAt(j) == 'D') j++;
                reverse(arr, l, j);
            }
        }
        return arr;
    }
    private void reverse(int[] arr, int l, int r){
        while(l < r){
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}