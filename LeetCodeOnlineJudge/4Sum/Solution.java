import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> fourSum(int num[], int target){
        if(num.length < 4) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int tuple[] = new int[4];
        int len = num.length;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < len - 3; i++){
            if(i > 0 && num[i] == num[i-1]) continue;
            for(int j = i + 1; j < len - 2; j++){
                if(j > i + 1 && num[j] == num[j-1]) continue;
                int l = j + 1;
                int r = len - 1;
                int goal = target - num[i] - num[j];
                tuple[0] = num[i];
                tuple[1] = num[j];
                while(l < r){
                    while(l < r && num[l] + num[r] < goal) l++;
                    while(l < r && num[l] + num[r] > goal) r--;
                    if(l < r && num[l] + num[r] == goal){
                        tuple[2] = num[l];
                        tuple[3] = num[r];
                        curr.add(tuple[0]);
                        curr.add(tuple[1]);
                        curr.add(tuple[2]);
                        curr.add(tuple[3]);
                        ret.add(curr);
                        curr = new ArrayList<Integer>();
                        l++;
                        r--;
                        while(l < r && num[l] == num[l - 1]) l++;
                        while(l < r && num[r] == num[r + 1]) r--;
                    }
                }
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {1, 2, 3, 10, 9, 8, 7, 6, 5, 4};
    }
}
