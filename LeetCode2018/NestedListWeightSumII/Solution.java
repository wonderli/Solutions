/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int result = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Deque<List<NestedInteger>> levels = new LinkedList<>();
        List<NestedInteger> curr = new LinkedList<>();
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger e : nestedList){
            if(e.isInteger()){
                curr.add(e);
            }else{
                queue.add(e);
            }
        }
        levels.add(curr);
        while(!queue.isEmpty()){
            int size = queue.size();
            curr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                NestedInteger e = queue.poll();
                for(NestedInteger c : e.getList()){
                    if(c.isInteger()){
                    curr.add(c);
                    }else{
                        queue.add(c);
                    }
                }
            }
            levels.add(curr);
        }
        int level = 1;
        int result = 0;
        while(!levels.isEmpty()){
            List<NestedInteger> l = levels.pollLast();
            int currValue = 0;
            for(NestedInteger e : l){
                currValue += e.getInteger();
            }
            result += currValue * level;
            level++;
        }
        return result;
    }
}