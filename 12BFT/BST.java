import java.util.NoSuchElementException;

public class BST<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	public void setLeftNode(Node l) { left = l; }
	public void setRightNode(Node r) { right = r; }
	public void setValue(T value) { data = value; }

	public Node getLeftNode() { return left; }
	public Node getRightNode() { return right; }
	public T getValue() { return data; }

	public int height() {
	    if (left != null && right != null) {
		return Math.max(left.height(), right.height()) + 1;
	    } else if (left != null) {
		return left.height() + 1;
	    } else if (right != null) {
		return right.height() + 1;
	    }
	    return 1;
	}

	public void add(T value) {
	    if (data == null) {
		data = value;
	    }
	    else if (data.compareTo(value) > 0) {
		if (left == null) {
		    left = new Node();
		    left.setValue(value);
		} else {
		    left.add(value);
		}
	    } else {
		if (right == null) {
		    right = new Node();
		    right.setValue(value);
		} else {
		    right.add(value);
		}
	    }
	}

	public void remove(T value) {
	    removeRecur(value);
	}

	private boolean removeRecur(T value) {
	    if (data.compareTo(value) == 0) {
		if (left.numChildren() == 0) {
		    data = left.getValue();
		    left = null;
		    return true;
		} else {
		    data = findGreatest(left);
		    return true;
		}
	    }

	    else {
		if (left != null) {
		    if (left.getValue().compareTo(value) == 0 &&
			left.numChildren() == 1) {
			setLeftNode(left.getLeftNode());
			setRightNode(left.getRightNode());
			return true;
		    } else if (left.getValue().compareTo(value) == 0 &&
			       left.numChildren() == 0) {
			left = null;
			return true;
		    } else if (left.removeRecur(value)) {
			return true;
		    }
		}

		if (right != null) {
		    if (right.getValue().compareTo(value) == 0 &&
			right.numChildren() == 1){
			setLeftNode(right.getLeftNode());
			setRightNode(right.getRightNode());
			return true;
		    } else if (right.getValue().compareTo(value) == 0 &&
			       right.numChildren() == 0) {
			right = null;
			return true;
		    } else if (right.removeRecur(value)) {
			return true;
		    }
		}
		return false;
	    }
	}

        private T findGreatest(Node n) {
	    if (n.getRightNode() == null) {
		T newValue = n.getValue();
		n = n.getLeftNode();
		return newValue;
	    }
	    if (n.getRightNode().numChildren() == 0) {
		T newValue = n.getRightNode().getValue();
		Node oldNode = n.getRightNode();
		oldNode = null;
		return newValue;
	    }
	    return findGreatest(n.getRightNode());
	}

	public int numChildren() {
	    int sum = 0;
	    if (left != null) {
		sum += 1;
	    }
	    if (right != null) {
		sum += 1;
	    }
	    return sum;
	}

	public String toString() {
	    String toRet = data + " ";
	    if (left == null) {
		toRet += "_" + " ";
	    } else {
		toRet += left;
	    }
	    if (right == null) {
		toRet += "_" + " ";
	    } else {
		toRet += right;
	    }
	    return toRet;
	}

	public boolean contains(T value) {
	    if (height() == 1) {
		return data.compareTo(value) == 0;
	    }
	    if (data.compareTo(value) == 0) {
		return true;
	    } else if (data.compareTo(value) > 0) {
		if (left != null) {
		    return left.contains(value);
		}
	    } else if (data.compareTo(value) < 0) {
		if (right != null) {
		    return right.contains(value);
		}
	    }
	    return false;
	}
    }

    private Node root;

    public int getHeight(){
	if (isEmpty()) {
	    return 0;
	}
	return root.height();
    }

    public void add(T value){
	if (isEmpty()) {
	    root = new Node();
	}
	root.add(value);
    }

    public T remove (T value) {
	if (isEmpty() || !root.contains(value)) {
	    throw new NoSuchElementException();
	}
	if (root.numChildren() == 0) {
	    T oldValue = root.getValue();
	    root = null;
	    return oldValue;
	}
	else if (root.numChildren() == 1 &&
		 root.getValue().compareTo(value) == 0) {
	    T oldValue;
	    if (root.getLeftNode() != null) {
		oldValue = root.getLeftNode().getValue();
		root = root.getLeftNode();
	    } else {
		oldValue = root.getRightNode().getValue();
		root = root.getRightNode();
	    }
	    return oldValue;
	} else {
	    root.remove(value);
	}
	return value;
    }

    public String toString(){
	if (isEmpty()) {
	    return "";
	}
	return root.toString();
    }

    public boolean contains(T value){
	if (isEmpty()) {
	    return false;
	}
	return root.contains(value);
    }

    public boolean isEmpty() {
	return root == null;
    }
}
