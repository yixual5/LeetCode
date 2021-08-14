/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> l = new ArrayList<>();
    private int idx = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flat(nestedList);
    }
    
    private void flat(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                l.add(i.getInteger());
            } else {
                flat(i.getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return l.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < l.size();
    }
}


// using stack(dequeue)
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> dq;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new ArrayDeque<>(nestedList);
    }
    
    private void flushToStack() {
        while (!dq.isEmpty() && !dq.peekFirst().isInteger()) {
            List<NestedInteger> temp = dq.removeFirst().getList();
            
            for (int i = temp.size() - 1; i >= 0; i--) {
                dq.addFirst(temp.get(i));
            }
        }
    }
    
    @Override
    public Integer next() {
        flushToStack();
        if (dq.isEmpty()) throw new NoSuchElementException();
        return dq.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        flushToStack();
        return !dq.isEmpty();
    }
}
