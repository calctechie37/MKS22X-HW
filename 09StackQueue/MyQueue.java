import java.util.*;

public class MyQueue<T> {
    private MyLinkedList<T> LinkedList;

    public MyQueue() {
        LinkedList = new MyLinkedList<T>();
    }

    public static void main(String[] args) {
	MyQueue<Integer> mq = new MyQueue<Integer>();
	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	
	// Test functions
	int amount;
	if (args.length > 0) {
	    amount = Integer.parseInt(args[0]);
	} else {
	    amount = 2000000;
	}
	for (int i = 0; i < amount; i++) {
	    int n = (int) (Math.random() * 10000);
	    mq.enqueue(i);
	    q.add(i);
	}
	while (!q.isEmpty() && q.size() == mq.size()) {
	    if ( !(q.peek()).equals(mq.peek()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	    if ( !(q.remove()).equals(mq.dequeue()) ) {
		System.out.println("Failed");
		System.exit(0);
	    }
	}
	if (mq.isEmpty()) {
	    System.out.println("Success!");
	} else {
	    System.out.println("Not empty!");
	}
    }

    public void enqueue(T item) {
	LinkedList.add(item);
    }

    public T dequeue() {
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

    boolean isEmpty() {
	return size() == 0;
    }
}
