public class runningMedian {
    private MyHeap<Integer> heapL;
    private MyHeap<Integer> heapR;
    private int size;
    private double median;

    public runningMedian() {
	size = 0;
	median = 0;
	heapL = new MyHeap<Integer>(true);
	heapR = new MyHeap<Integer>(false);
    }
    
    public double getMedian() {
	return median;
    }
    
    public void add(Integer x) {
	if (size == 0) {
	    heapL.add(x);
	    median = x.doubleValue();
	} else {
	    if (x < median) {
		heapL.add(x);
	    } else {
		heapR.add(x);
	    }
	    while (heapL.size() - heapR.size() > 1) {
		heapR.add(heapL.remove());
	    }
	    while (heapR.size() - heapL.size() > 1) {
		heapL.add(heapR.remove());
	    }
	    calculateMedian();
	}
	size++;
    }

    private void calculateMedian() {
	if (heapL.size() == heapR.size()) {
	    median = ( heapL.peek().doubleValue() + heapR.peek().doubleValue() ) / 2;
	} else {
	    if (heapL.size() > heapR.size()) {
		median = heapL.peek().doubleValue();
	    } else {
		median = heapR.peek().doubleValue();
	    }
	}
    }
    
    public int size() {
	return size;
    }

    public MyHeap getLeft() {
	return heapL;
    }

    public MyHeap getRight() {
	return heapR;
    }
}
