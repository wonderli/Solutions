import java.util.*;
class Solution2 {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n+1];
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for(int j = 1; j <= n; j++){
            if(s.charAt(j-1) == 'I'){
                stack.push(j);
                while(!stack.isEmpty()){
                    res[i] = stack.pop();
                    i++;
                }
            }else{
                stack.push(j);
            }
        }
        stack.push(n+1);
        while(!stack.isEmpty()){
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
}
