// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> itr;
    private Integer peek = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    itr = iterator;
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peek != null) return peek;
        if (!itr.hasNext()) throw new NoSuchElementException();
        peek = itr.next();
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (peek != null) {
            Integer temp = peek;
            peek = null;
	        return temp;
        }
        if (itr.hasNext()) {
            return itr.next();
        }
        throw new NoSuchElementException();
        
	}
	
	@Override
	public boolean hasNext() {
        return peek != null || itr.hasNext();
	}
}


// get peek at constructor
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> itr;
    private Integer next = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
        if (!iterator.hasNext()) throw new NoSuchElementException();
        next = iterator.next();
	    itr = iterator;
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (next == null) throw new NoSuchElementException();
        Integer temp = next;
        next = null;
        if (itr.hasNext()) {
            next = itr.next();
        }
        return temp;
        
	}
	
	@Override
	public boolean hasNext() {
        return next != null;
	}
}
