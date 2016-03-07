import java.util.*;

public class QuickSelect{
    
    public int QuickSelect(int[] data, int k){
	return QuickSelect(data, 0, data.length - 1, k - 1);
    }

    private int QuickSelect(int[] data, int first, int last, int k) {
	if (first <= last) {
	    int pivot = partition(data, first, last);
	    if (pivot == k) {
		return data[k];
	    }
	    if (pivot > k) {
		return QuickSelect(data, first, pivot - 1, k);
	    }
	    return QuickSelect(data, pivot + 1, last, k);
	}
	return Integer.MIN_VALUE;
    }
 
    private int partition(int[] data, int first, int last) {
	int pivot = first + new Random().nextInt(last - first + 1);
	swap(data, last, pivot);
	for (int i = first; i < last; i++) {
	    if (data[i] > data[last]) {
		swap(data, i, first);
		first++;
	    }
	}
	swap(data, first, last);
	return first;
    }
 
    private void swap(int[] data, int x, int y) {
	int tmp = data[x];
	data[x] = data[y];
	data[y] = tmp;
    }
}
