public class MyLinkedList{

    private LNode head;
    private LNode current;
    private LNode tail;

    public int size = 1;

    public MyLinkedList(LNode thead, LNode tcurrent){
	setHead(thead);
	setCurrent(tcurrent);
	while(current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail();
	setCurrent(tcurrent);
    }

    public MyLinkedList(LNode thead){
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

    public void setHead(LNode thead){
	head = thead;
    }

    public LNode getHead(){
	return head;
    }

    public void setCurrent(LNode tcurrent){
	current = tcurrent;
    }

    public LNode getCurrent(){
	return current;
    }

    public void setTail(){
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail(current);
    }

    public void setTail(LNode t){
	tail = t;
    }

    public LNode getTail(){
	return tail;
    }

    public int get(int index){
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

    public boolean add(int value){
	add(size, value);
	return true;
    }

    public void add(int index, int value){
	try{
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    current.setNext(new LNode(value,current.getNext()));
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

    public int indexOf(int value){
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
    
    public int remove(){
	try {
	    current = head.getNext();
	    int hold = head.getValue();
	    setHead(current);
	    return hold;
	} catch (Exception e){
	    System.out.println("Element not found");
	    System.exit(0);
	}
	return -1;
    }

    public int remove(int index){
	try {
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    int hold = current.getNext().getValue();
	    current.getNext().setNext(current.getNext().getNext());
	    size--;
	    return hold;
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public static void main(String[]args){
	LNode ln = new LNode(5);
	MyLinkedList m = new MyLinkedList(ln);

	System.out.println(ln.toString()); // [ 5 ]
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
