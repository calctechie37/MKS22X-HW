import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    
    private ArrayDeque<T> q;

    public FrontierQueue(){
	q = new ArrayDeque<T>();
    }

    public void add(T element){
	q.addLast(element);
    }

    public T next() {
	if (!hasNext()) {
	    throw new NoSuchElementException();
	}
	return q.removeFirst();
    }

    public boolean hasNext() {
	return !q.isEmpty();
    }

    public String toString() {
	return q.toString();
    }
}
