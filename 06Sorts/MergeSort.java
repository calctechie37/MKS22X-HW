import java.util.*;

public class MergeSort{
    
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

    public static String toString(int[] a){
	String ans = "[ " + a[0];
	for(int i = 1; i < a.length - 1; i++){
	    ans += ", " + a[i];
	}
	return ans + " ]";
    }

    public static void main(String[] args){
	int n;
	if (args.length > 0){
	    n = Integer.parseInt(args[0]);
	} else{
	    n = 1000000;
	}
	int [] a = new int[n];
	Random r = new Random();

	for(int i = 0; i < n; i++){
	    a[i] = r.nextInt(2000000) + 1;
	}
	
	mergeSort(a);
	System.out.println("Done");
    }
}
