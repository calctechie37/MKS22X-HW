import java.util.*;

public class MyStack<T>{
    
    public MyLinkedList<T> stack;

    public myStack(){
	stack = new MyLinkedList<T>();
    }

    public void push(T item){
	stack.add(0, item);
    }

    public T pop(){
	if (isEmpty()){
	    throw new NoSuchElementException();
	}
	return stack.remove(0);
    }

    public T peek(){
    }

    public int size(){
    }

    public boolean isEmpty(){
	
   }
}
