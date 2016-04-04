import java.util.*;

public class MyDeque<T> {
    private MyLinkedList<T> LinkedList;

    public MyDeque() {
	LinkedList = new MyLinkedList<T>();
    }

    public void addFirst(T value) {
	LinkedList.add(0, value);
    }

    public void addLast(T value) {
	LinkedList.add(value);
    }

    public T removeFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return LinkedList.remove(0);
    }

    public T removeLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return LinkedList.remove(LinkedList.size() - 1);
    }

    public T getFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return LinkedList.get(0);
    }

    public T getLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return LinkedList.get(LinkedList.size() - 1);
    }

    public boolean isEmpty() {
	return LinkedList.size() == 0;
    }
}
