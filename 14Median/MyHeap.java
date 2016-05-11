import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap() {
	size = 1;
	data = (T[]) new Comparable[size];
	isMax = true;
    }

    public MyHeap(T[] array) {
	size = array.length;
	data = (T[]) new Comparable[size + 1];
	for (int i = 1; i < size + 1; i++) {
	    data[i] = array[i - 1];
	}
	isMax = true;
	heapify();
    }

    public MyHeap(boolean isMax) {
	size = 1;
	data = (T[]) new Comparable[size];
	this.isMax = isMax;
    }

    public MyHeap(T[] array, boolean isMax) {
	size = array.length;
	data = (T[]) new Comparable[size + 1];
	for (int i = 1; i < size + 1; i++) {
	    data[i] = array[i - 1];
	}
	this.isMax = isMax;
	heapify();
    }

    public int size() {
	return size;
    }

    public T peek() {
	return data[1];
    }


    private void pushDown(int k) {
	if (size >= 2*k) {
	    if (size >= 2*k + 1) {
		int swapIndex = 0;
		if (isMax) {
		    if (data[2*k].compareTo(data[2*k + 1]) >= 0) { swapIndex = 2*k; }
		    else { swapIndex = 2*k + 1; }
		} else {
		    if (data[2*k].compareTo(data[2*k + 1]) < 0) { swapIndex = 2*k; }
		    else { swapIndex = 2*k + 1; }
		}
		if (isMax) {
		    if (data[k].compareTo(data[swapIndex]) < 0) {
			swap(k, swapIndex);
			pushDown(swapIndex);
		    }
		} else {
		    if (data[k].compareTo(data[swapIndex]) > 0) {
			swap(k, swapIndex);
			pushDown(swapIndex);
		    }
		}
	    } else {
		if (isMax) {
		    if (data[k].compareTo(data[2*k]) < 0) {
			swap(k, 2*k);
			pushDown(2*k);
		    }
		} else {
		    if (data[k].compareTo(data[2*k]) > 0) {
			swap(k, 2*k);
			pushDown(2*k);
		    }
		}
	    }
	}
    }

    private void pushUp(int k) {
	if (k >= 2) {
	    if (isMax) {
		if (data[k].compareTo(data[k/2]) >= 1) {
		    swap(k, k/2);
		    pushUp(k/2);
		}
	    } else {
		if (data[k].compareTo(data[k/2]) <= -1) {
		    swap(k, k/2);
		    pushUp(k/2);
		}
	    }
	}
    }

    private void swap(int ind1, int ind2) {
	T tempVal = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = tempVal;
    }

    private void heapify() {
	for (int i = size/2; i > 0; i--) {
	    pushDown(i);
	}
    }

    public T delete() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T oldValue = data[1];
	if (size == 1) {
	    data[1] = null;
	    return oldValue;
	}
	data[1] = data[size];
	data[size] = null;
	size--;
	pushDown(1);
	return oldValue;
    }

    public void add(T x) {
	if (size + 1 > data.length - 1) {
	    doubleSize();
	}
	data[size + 1] = x;
	pushUp(size + 1);
	size++;
    }

    private void doubleSize() {
	T[] newData = (T[]) new Comparable[data.length * 2];
	for (int i = 1; i < size + 1; i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }

    public String toString() {
	return Arrays.toString(data);
    }
}
