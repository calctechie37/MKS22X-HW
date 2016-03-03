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
}
	    
