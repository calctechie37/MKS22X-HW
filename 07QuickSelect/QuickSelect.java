import java.util.*;

public class QuickSelect{
    
    public static int QuickSelect(int[] data, int k){
	return QuickSelect(data, 0, data.length - 1, k - 1);
    }

    private static int QuickSelect(int[] data, int first, int last, int k) {
	if (first <= last) {
	    
	    int pivot = partition(data, first, last);

	    if (k == pivot) {
		return data[pivot];
	    }
	    if (k < pivot) {
		return QuickSelect(data, first, pivot - 1, k);
	    }
	    return QuickSelect(data, pivot + 1, last, k);
	}
	return Integer.MIN_VALUE;
    }
 
    private static int partition(int[] data, int first, int last) {
	int pivot = first + new Random().nextInt(last - first + 1);
	int pivotValue = data[pivot];
	swap(data, pivot, last);
	for (int i = first; i < last; i++) {
	    if (data[i] <= pivotValue) {
		swap(data, first, i);
		first++;
	    }
	}
	swap(data, first, last);
	return first;
    }
 
    private static void swap(int[] data, int x, int y) {
	int tmp = data[x];
	data[x] = data[y];
	data[y] = tmp;
    }
    
    public static void main(String[] args){
	int n;
	if (args.length > 0){
	    n = Integer.parseInt(args[0]);
	} else{
	    n = 10;
	}
	int [] a = new int[n];
	Random r = new Random();
	for(int i = 0; i < n; i++){
	    a[i] = r.nextInt(2000000) - 1;
	}
	
	System.out.println(Arrays.toString(a));
	System.out.println(QuickSelect(a, 3));
	System.out.println(Arrays.toString(a));
	Arrays.sort(a);
	System.out.println(Arrays.toString(a));
	System.out.println(a[2]);
    }
}
