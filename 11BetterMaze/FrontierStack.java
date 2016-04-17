import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    
    private Stack<T> s;

    public FrontierStack() {
	s = new Stack<T>();
    }

    public void add(T element) {
	s.push(element);
    }

    public T next() {
	if (!hasNext()) {
	    throw new NoSuchElementException();
	}
	return s.pop();
    }

    public boolean hasNext() {
	return !s.isEmpty();
    }

    public String toString() {
	return s.toString();
    }
}
