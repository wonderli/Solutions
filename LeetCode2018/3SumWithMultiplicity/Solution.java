import java.util.*;
class Solution {
    int mod = (int) 1e9 + 7;
    public int threeSumMulti(int[] arr, int target) {
        long result = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i < n-2; i++){
            int t = target - arr[i];
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                if(arr[j] + arr[k] < t){
                    j++;
                }else if(arr[j] + arr[k] > t){
                    k--;
                }else if(arr[j] != arr[k]){
                    int left = 1;
                    int right = 1;
                    while(j + 1 < k && arr[j] == arr[j+1]){
                        left++;
                        j++;
                    }
                    while(k - 1 > j && arr[k] == arr[k-1]){
                        right++;
                        k--;
                    }
                    result += left * right;
                    result = result % mod;
                    j++;
                    k--;
                }else{
                    result += (k - j + 1) * (k - j)/2;
                    result = result % mod;
                    break;
                }
            }
        }
        return (int)result;
    }
}