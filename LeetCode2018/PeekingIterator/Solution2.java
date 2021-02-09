import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer next = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    if(iterator.hasNext()){
            next = iterator.next();
        }
        iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(next == null){
            throw new NoSuchElementException();
        }
        Integer ret = next;
        next = null;
        if(iter.hasNext()){
            next = iter.next();
        }
        return ret;
	}
	
	@Override
	public boolean hasNext() {
        return next != null;
	}
}
