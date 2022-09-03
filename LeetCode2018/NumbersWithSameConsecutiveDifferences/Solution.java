import java.util.*;
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        helper(n, 0, k, new StringBuilder(), result);
        int size = result.size();
        int[] res = new int[size];
        for(int i =0; i < size;i ++){
            res[i] = result.get(i);
        }
        return res;
    }
    
    private void helper(int n, int index, int k, StringBuilder curr, List<Integer> res){
        if(index == n){
            res.add(Integer.parseInt(curr.toString()));
            return ;
        }
        int start = index == 0 ? 1 : 0;
        for(int j = start; j <= 9; j++){
            if(index == 0){
                curr.append(j);
                helper(n,index+1, k, curr, res);
                curr.setLength(curr.length() - 1);
            }else{
                int prev = curr.charAt(curr.length() - 1) - '0';
                if(Math.abs(j - prev) == k) {
                    curr.append(j);
                    helper(n,index+1, k, curr, res);
                    curr.setLength(curr.length() - 1);
                }
            }
        }
    }
}
