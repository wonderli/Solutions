import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer currPeek;
	public PeekingIterator(Iterator<Integer> iterator) {
	    iter = iterator;
        currPeek = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(currPeek != null){
            return currPeek;
        }
        if(iter.hasNext()){
            currPeek = iter.next();
            return currPeek;
        }
        return null;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(currPeek != null){
            Integer v = currPeek;
            currPeek = null;
            return v;
        }
        if(!iter.hasNext()){
            throw new NoSuchElementException();
        }
        return iter.next();
	}
	
	@Override
	public boolean hasNext() {
	    return currPeek != null || iter.hasNext();
	}
}
