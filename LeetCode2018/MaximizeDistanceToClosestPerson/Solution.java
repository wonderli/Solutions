class Solution {
    public int maxDistToClosest(int[] seats) {
        if(seats.length == 0) return 0;
        int n = seats.length;
        int[] left = new int[n];
        int last = -1;
        for(int i =0; i < n; i++){
            if(seats[i] == 1){
                last = i;
                left[i] = 0;
            }else{
                if(last == -1){
                    left[i] = n;
                }else{
                    left[i] = i - last;
                }
            }
        }
        
        int[] right = new int[n];
        int r = -1;
        for(int j = n - 1; j>= 0;j--){
            if(seats[j] == 1){
                r = j;
                right[j] = 0;
            }else{
                if(r == -1){
                    right[j] = n;
                }else{
                    right[j] = r - j;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n;i++){
            int curr = Math.min(left[i], right[i]);
            max = Math.max(curr, max);
        }
        return max;
        
    }
}