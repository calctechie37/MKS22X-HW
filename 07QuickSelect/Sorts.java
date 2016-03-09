import java.util.Arrays;
import java.util.Random;

public class Sorts{
    
    public static void fillRandom(int[] data){
	Random random = new Random();
	for(int i = 0; i < data.length; i++){
	    int sign = (int)Math.round(Math.random()) * 2 - 1;
	    data[i] = sign * random.nextInt(Integer.MAX_VALUE);
	}
    }

    public static void swap(int[]data, int index, int endex){
	int temp = data[index];
	data[index] = data[endex];
	data[endex] = temp;
    }

    public static void selectionSort(int [] data){
	for(int i = 0; i < data.length; i++){
	    int target = data[i];
	    int index = i;
	    for(int j = i; j < data.length; j++){
		if (data[j] < target){
		    target = data[j];
		    index = j;
		}
	    }
	    int temp = data[i];
	    data[i] = target;
	    data[index] = temp;
	}
    }

    public static void insertionSort(int[]data){
	for(int i = 1; i < data.length; i++){
	    for(int j = i; j > 0 && data[j] < data[j - 1]; j--){
		int x = data[j - 1];
		data[j - 1] = data[j];
		data[j] = x;
	    }
	}
    }

    public static void bubbleSort(int[]data){
	int target = data.length;
	boolean changes = true;
	while (changes){
	    changes = false;
	    for(int j = 1; j < target; j ++){
		if(data[j] < data[j - 1]) {
		    int temp = data[j];
		    data[j] = data[j - 1];
		    data[j - 1] = temp;
		    changes = true;
		}
	    }
	    target--;
	}
    }

    public static int[] merge(int[] x, int[] y){
	int[] ans = new int[x.length + y.length];
	int xstart = 0;
	int ystart = 0;
	while (xstart < x.length && ystart < y.length){
	    if (x[xstart] < y[ystart]){
		ans[xstart + ystart] = x[xstart];
		xstart++;
	    }else{
		ans[xstart + ystart] = y[ystart];
		ystart++;
	    }
	}
	if (xstart >= x.length){
	    for(int i = ystart; i < y.length; i++){
		ans[i + x.length] = y[i];
	    }
	}
	if (ystart >= y.length){
	    for(int i = xstart; i < x.length; i++){
		ans[i + y.length] = x[i];
	    }
	}
	return ans;
    }

    public static int[] copyHalf(int[] a, int whichHalf){
	int [] ans = new int[a.length / 2];
	int size = ans.length;
	if (whichHalf == 1){
	    for(int i = 0; i < size; i++){
		ans[i] = a[i];
	    }
	}else{
	    ans = new int[a.length - size];
	    for(int i = size; i < a.length; i++){
		ans[i - size] = a[i];
	    }
	}
	return ans;
    }

    public static void mergeSort(int[] x){
	int[] newArray = mergeSortH(x);
	for(int i = 0; i < newArray.length; i++){
	    x[i] = newArray[i];
	}
    }

    public static int[] mergeSortH(int[] x){
	if (x.length < 2){
	    return x;
	}
	return merge(mergeSortH(copyHalf(x, 1)), mergeSortH(copyHalf(x, 2)));
    }

    public static string name(){
	return "7, Chan, Patrick";
    }

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
}
	    
