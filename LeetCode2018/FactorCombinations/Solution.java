import java.util.*;
class Solution{
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(2, n, new ArrayList<>(), res);
        return res;
    }
    public void helper(int index, int n, List<Integer> curr, List<List<Integer>> res){
        if(n <= 1){
            if(curr.size() > 1){
                res.add(curr);
            }
            return;
        }
        for(int i = index; i <= n; i++){
            if(n % i == 0 ){
                List<Integer> tmp = new ArrayList<>(curr);
                curr.add(i);
                helper(i, n/i, curr, res);
                curr = tmp;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.getFactors(8));
        System.out.println(sol.getFactors(12));
    }
}