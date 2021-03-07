import java.util.*;
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 2, n);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> curr, int start, int n){
        for(int i = start; i * i <= n; i++){
            if(n%i == 0){
                curr.add(i);
                curr.add(n/i);
                result.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
                helper(result, curr, i, n/i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}