import java.util.*;

public class MyStack<T> {
    private MyLinkedList<T> LinkedList;

    public MyStack() {
	LinkedList = new MyLinkedList<T>();
    }

    public static void main(String[] args) {
	MyStack<Integer> ms = new MyStack<Integer>();
	Stack<Integer> s = new Stack<Integer>();
	
	// Test functions
	int amount;
	if (args.length > 0) {
	    amount = Integer.parseInt(args[0]);
	} else {
	    amount = 1000000;
	}
	for (int i = 0; i < amount; i++) {
	    int n = (int) (Math.random() * 10000);
	    ms.push(i);
	    s.push(i);
	}
	while (!s.empty() && s.size() == ms.size()) {
	    if ( !(s.peek()).equals(ms.peek()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	    if ( !(s.pop()).equals(ms.pop()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	}
	if (ms.isEmpty()) {
	    System.out.println("Success!");
	} else {
	    System.out.println("Not empty!");
	}
    }

    public void push(T item) {
	LinkedList.add(0, item);
    }

    public T pop() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return LinkedList.remove(0);
    }

    public T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return LinkedList.get(0);
    }

    public int size() {
	return LinkedList.size();
    }

    public boolean isEmpty() {
	return size() == 0;
    }
}
