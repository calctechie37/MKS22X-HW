public class MyLinkedList<T>{
    
    private static class LNode<T>{
	private T value;
	private LNode<T> next;

	public LNode(T v){
	    setValue(v);
	    setNext(null);
	}

	public LNode(T v, LNode<T> n){
	    setValue(v);
	    setNext(n);
	}

	public void setValue(T v){
	    value = v;
	}

	public void setNext(LNode<T> n){
	    next = n;
	}

	public T getValue(){
	    return value;
	}

	public LNode<T> getNext(){
	    return next;
	}
    }
    
    private LNode<T> head;
    private LNode<T> current;
    private LNode<T> tail;

    public int size = 1;

    public MyLinkedList(LNode<T> thead, LNode<T> tcurrent){
	setHead(thead);
	setCurrent(tcurrent);
	while(current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail();
	setCurrent(tcurrent);
    }

    public MyLinkedList(LNode<T> thead){
	setHead(thead);
	setCurrent(thead);
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail();
	setCurrent(thead);
    }

    public String name(){
	return "7, Chan, Patrick";
    }

    public void setHead(LNode<T> thead){
	head = thead;
    }

    public LNode<T> getHead(){
	return head;
    }

    public void setCurrent(LNode<T> tcurrent){
	current = tcurrent;
    }

    public LNode<T> getCurrent(){
	return current;
    }

    public void setTail(){
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail(current);
    }

    public void setTail(LNode<T> t){
	tail = t;
    }

    public LNode<T> getTail(){
	return tail;
    }

    public T get(int index){
	setCurrent(head);
	try{
	    while(index > 0){
		setCurrent(current.getNext());
		index--;
	    }
	    return current.getValue();
	}catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public boolean add(T value){
	add(size, value);
	return true;
    }

    public void add(int index, T value){
	try{
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    current.setNext(new LNode<T>(value,current.getNext()));
	    size++;
	}catch (Exception e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public String toString(){
	setCurrent(head);
	String ans = "[ " + current.getValue();
	if (head.getNext() != null){
	    setCurrent(current.getNext());
	    while (current.getNext() != null){
		ans += ", " + current.getValue();
		setCurrent(current.getNext());
	    }
	    ans += ", " + current.getValue();
	}
	ans += " ]";
	return ans;
    }

    public int indexOf(T value){
	int i = 0;
	while (current.getNext().getValue() != value){
	    if (current.getNext().getNext() == null && current.getValue() != value){
		return -1;
	    }
	    i++;
	    setCurrent(current.getNext());
	}
	return i;
    }

    public int size(){
	return size;
    }
    
    public T remove(){
	try {
	    current = head.getNext();
	    T hold = head.getValue();
	    setHead(current);
	    return hold;
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public T remove(int index){
	try {
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    T hold = current.getNext().getValue();
	    current.getNext().setNext(current.getNext().getNext());
	    size--;
	    return hold;
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public static void main(String[]args){
	LNode<Integer> ln = new LNode<Integer>(5);
	MyLinkedList<Integer> m = new MyLinkedList<Integer>(ln);

	System.out.println(m.toString()); // [ 5 ] 
	m.add(1); 
	System.out.println(m.toString()); // [ 5, 1 ]
	System.out.println(m.size()); // 2
	m.add(1,8);
	System.out.println(m.toString()); // [ 5, 8, 1 ]
	System.out.println(m.size()); // 3
	System.out.println(m.remove()); // 5
	System.out.println(m.toString()); // [ 8, 1 ]
    }
    
}
