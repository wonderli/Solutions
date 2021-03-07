import java.util.*;
public class Solution2{
    public List<List<Integer>> generate(int numRows) {
           List<List<Integer>> ret = new ArrayList<>();
           if(numRows == 0) return ret;
           List<Integer> curr = new ArrayList<>();
           curr.add(1);
           ret.add(curr);
           for(int i = 1; i < numRows; i++){
               List<Integer> prev = ret.get(ret.size() - 1);
               List<Integer> c = new ArrayList<>();
               c.add(1);
               for(int j = 0; j < prev.size() - 1; j++){
                   int a = prev.get(j);
                   int b = prev.get(j + 1);
                   c.add(a + b);
               }
               c.add(1);
               ret.add(c);
           }
           return ret;
       }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
