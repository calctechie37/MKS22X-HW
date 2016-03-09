import java.util.*;

public class quickSort{
    
    public static void quickSort(int[] data){
	quickSort(data, 0, data.length - 1);
    }
    
    private static void quickSort(int[] data, int first, int last) {
	if (first <= last) {
	    
	    int pivot = partition(data, first, last);
	    
	    quickSort(data, first, pivot - 1);
	    quickSort(data, pivot + 1, last);
	}
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
	    n = 100000;
	}
	int [] a = new int[n];
	Random r = new Random();
	
	for(int i = 0; i < n; i++){
	    a[i] = r.nextInt(2000000000) - 1;
	}

	quickSort(a);
    }
}
