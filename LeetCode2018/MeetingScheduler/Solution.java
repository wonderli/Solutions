import java.util.*;
class Solution{
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[1] - b[1]));
        int i = 0;
        int m = slots1.length;
        int j = 0;
        int n = slots2.length;
        while(i < m && j < n){
            int[] a = slots1[i];
            int[] b = slots2[j];
            int l = Math.max(a[0], b[0]);
            int r = Math.min(a[1], b[1]);
            if(r - l >= duration){
                return Arrays.asList(l, l + duration);
            }else if(a[1] < b[1]){
                i++;
            }else{
                j++;
            }
        }
        return new ArrayList<>();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
