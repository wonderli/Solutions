import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}


class NestedIterator implements Iterator<Integer> {

    List<Integer> list = new ArrayList<>();
    Iterator<Integer> iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
        iterator = list.iterator();
    }
    private void dfs(List<NestedInteger> nl){
        for(int i = 0; i < nl.size(); i++){
            NestedInteger curr = nl.get(i);
            if(curr.isInteger()){
                list.add(curr.getInteger());
            }else{
                List<NestedInteger> nested = curr.getList();
                dfs(nested);
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
