import java.util.*;
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0;
        int sum = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel = new ArrayList<>();
            for(NestedInteger e : nestedList){
                if(e.isInteger()){
                    unweighted += e.getInteger();
                }else{
                    nextLevel.addAll(e.getList());
                }  
            }
            sum += unweighted;
            nestedList = nextLevel;
        }
        return sum;
    }
}