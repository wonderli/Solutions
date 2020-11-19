import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        makeTopInteger();
        return !stack.isEmpty();
    }
    
    private void makeTopInteger(){
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            List<NestedInteger> nested = stack.pop().getList();
            for(int i = nested.size() -1; i>=0; i--){
                stack.push(nested.get(i));
            }
        }
    }
}
