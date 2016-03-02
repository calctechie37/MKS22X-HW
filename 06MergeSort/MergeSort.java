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

    public static int[] mergeSort(int[] x){
	if (x.length < 2){
	    return x;
	}
	return merge(mergeSort(copyHalf(x, 1)), mergeSort(copyHalf(x, 2)));
    }

    public static String toString(int[] a){
	String ans = "[ " + a[0];
	for(int i = 1; i < a.length - 1; i++){
	    ans += ", " + a[i];
	}
	return ans + " ]";
    }

    public static void main(String[] args){
	int n = 11;
	int [] a = new int[n];
	Random r = new Random();
	
	System.out.println(toString(a));

	for(int i = 0; i < n; i++){
	    a[i] = r.nextInt(20) + 1;
	}
	
	System.out.println(toString(a));

	int type = Integer.parseInt(args[0]);
	if (type == 0){
	    Arrays.sort(a);
	}else{
	    a = mergeSort(a);
	}
	System.out.println(toString(a));
    }
}
