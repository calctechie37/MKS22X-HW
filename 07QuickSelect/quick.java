import java.util.*;

public class quick{
    
    public static int QuickSelectOld(int[] data, int k){
	return QuickSelectOld(data, 0, data.length - 1, k - 1);
    }

    public static void quickSortOld(int[] data){
	quickSortOld(data, 0, data.length - 1);
    }


    private static int QuickSelectOld(int[] data, int first, int last, int k) {
	if (first <= last) {
	    
	    int pivot = partitionOld(data, first, last);

	    if (k == pivot) {
		return data[pivot];
	    }
	    if (k < pivot) {
		return QuickSelectOld(data, first, pivot - 1, k);
	    }
	    return QuickSelectOld(data, pivot + 1, last, k);
	}
	return Integer.MIN_VALUE;
    }

    private static void quickSortOld(int[] data, int first, int last){
	if (first <= last){
	    int pivot = partitionOld(data, first, last);
	    
	    quickSortOld(data, first, pivot - 1);
	    quickSortOld(data, pivot + 1, last);
	}
    }

    private static int partitionOld(int[] data, int first, int last) {
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
    
    public static void quickSort(int[] data){
	quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int first, int last){
	if (first <= last){
	    int[] bounds = partition(data, first, last);
	    if  (bounds[0] > 0){
		quickSort(data, first, bounds[0] - 1);
	    }
	    if (bounds[1] < data.length - 1){
		quickSort(data, bounds[1] + 1, last);
	    }
	}
    }

    private static int[] partition(int[] data, int first, int last){
	int lastCopy = last;
	if (first == last){
	    int[] bounds = {last, last};
	    return bounds;
	}
	int pivot = (int)(Math.random() * (last - first + 1)) + first;
	int value = data[pivot];
	swap(data, pivot, last);
	last--;
	
	int secondRight = -1;
	while (first < last && (secondRight == -1) || secondRight > first){
	    if (data[first] > value){
		swap(data, first, last);
		last--;
	    }else if (data[first] < value){
		first++;
	    }else{
		if (secondRight == -1){
		    swap(data, first, last);
		    secondRight = last;
		}else{
		    swap(data, first, --secondRight);
		}
	    }
	}
	if (data[last] < value){
	    swap(data, ++last, lastCopy);
	}else{
	    swap(data, last, lastCopy);
	}
	int[] bounds = {first, last};
	return bounds;
    }

    private static void swap(int[] data, int x, int y) {
	int tmp = data[x];
	data[x] = data[y];
	data[y] = tmp;
    }
    

    public static String name(){
	return "7, Chan, Patrick";
    }

    public static void main(String[] args){
	int n;
	if (args.length > 0){
	    n = Integer.parseInt(args[0]);
	} else{
	    n = 100000000;
	}
	int [] a = new int[n];
	Random r = new Random();
	for(int i = 0; i < n; i++){
	    a[i] = r.nextInt(3);//2000000) - 1;
	}
	
	//System.out.println(Arrays.toString(a));
	//System.out.println(QuickSelectOld(a, 3));
	//System.out.println(Arrays.toString(a));
	quickSort(a);
	//System.out.println(Arrays.toString(a));
	//System.out.println(a[2]);
    }
}
