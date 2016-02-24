import java.util.*;
import java.io.*;

public class Bronze{
    public static void main(String[] args){
	String filename = "makelake.in";
	File infofile = new File(filename);
	try{
	    Scanner in = new Scanner(infofile);//.useDelimiter("\\D");
	    
	    int rows = in.nextInt();
	    int cols = in.nextInt();
	    int[][] pasture = new int[rows][cols];
	    int waterElevation = in.nextInt();
	    int stompElevation = in.nextInt();
	    
	    for(int i = 0; i < rows; i++){
		for(int j = 0; j < cols; j++){
		    pasture[i][j] = in.nextInt();
		}
	    }
	    
	    for(int i = 0; i < stompElevation; i++){
		int row = in.nextInt();
		int col = in.nextInt();
		int depressBy = in.nextInt();
		stomp(pasture, row - 1, col - 1, depressBy);
	    }
	    
	    System.out.println(findVolume(pasture, waterElevation) * 72 * 72 + ",7,Chan,Patrick");
	}catch (FileNotFoundException e){
	    System.out.println("File not found!");
	}
    }
    
    public static void stomp(int[][] pasture, int row, int col, int stompDepth){
	int max = pasture[row][col];
	for(int r = 0; r < 3; r++){
	    for(int c = 0; c < 3; c++){
		if(pasture[row + r][col + c] > max){
		    max = pasture[row + r][col + c];
		}
	    }
	}
	max -= stompDepth;
	for(int r = row; r < pasture.length && r < row + 3; r++){
	    for(int c = col; c < pasture[0].length && c < row + 3; c++){
		if(pasture[r][c] > max){
			pasture[r][c] = max;
		}
	    }
	}
    }
    
    public static int findVolume(int[][] pasture, int waterElevation){
	int sum = 0;
	for(int row = 0; row < pasture.length; row++){
	    for(int col = 0; col < pasture[0].length; col++){
		if(pasture[row][col] <= waterElevation){
		    pasture[row][col] = waterElevation - pasture[row][col];
		    sum += pasture[row][col];
		}else{
		    pasture[row][col] = 0;
		}
	    }
	}
	return sum;
    }
}

