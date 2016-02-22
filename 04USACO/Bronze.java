import java.util.Scanner;

public class LakeMaking {
	public static void main(String[] args){
		String filename = "makelake.in";
		Scanner in = new Scanner(filename).useDelimiter("\\D");
	}

	int rows = in.nextInt();
	int cols = in.nextInt();
	int[][] pasture = new int[rows][cols];
	int waterElevation = in.nextInt();
	int stompElevation = in.nextInt();

	for(int i = 0; i < rows.length; i++){
		for(int j = 0; j < cols.length; j++){
			pasture[i][j] = in.nextInt();
		}
	}

	for(int i = 0; i < stompElevation; i++){
		int row = in.nextInt();
		int col = in.nextInt();
		int depressBy = in.nextInt();
		stomp(pasture, row, col, depressBy);
	}

