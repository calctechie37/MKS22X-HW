import java.util.*;
import java.io.*;

public class Silver{
    String[][] pasture;
    int N, M, T;
    int R1, C1, R2, C2;
    
    public Silver(){
	File infofile = new File("ctravel.in");
	try{
	    Scanner in = new Scanner(infofile);
	    int line = 0;
	    while (in.hasNextLine()){
		String text = in.nextLine();
		if (line == 0){
		    String[] line0 = text.split(" ");
		    N = Integer.parseInt(line0[0]);
		    M = Integer.parseInt(line0[1]);
		    T = Integer.parseInt(line0[2]);
		    pasture = new String[N][M];
		}
		if (line > 0 && line < N + 1){
		    String[] pastureRow = text.split("");
		    for(int col = 0; col < M; col++){
			pasture[line - 1][col] = pastureRow[col];
		    }
		}
		
		if (line == N + 1){
		    String[] startEnd = text.split(" ");
		    R1 = Integer.parseInt(startEnd[0]);
		    C1 = Integer.parseInt(startEnd[1]);
		    R2 = Integer.parseInt(startEnd[2]);
		    C2 = Integer.parseInt(startEnd[3]);
		}
		line++;
	    }
	}catch (FileNotFoundException e){
	    System.out.println("File not Found!");
	    System.exit(0);
	}
    }

    public int solution(){
	return travel(R1 - 1, C1 - 1, T);
    }

    public int travel(int row, int col, int time){
	if (row < 0 || row >= N || col < 0 || col >= M || time < 0){
	    return 0;
	}else if (time == 0 && row == R2 - 1 && col == C2 - 1){
	    return 1;
	}else if (pasture[row][col] == "*"){
	    return 0;
	}

	return travel(row + 1, col, time - 1) + 
	    travel(row - 1, col , time - 1) + 
	    travel(row, col + 1, time - 1) + 
	    travel(row, col - 1, time - 1);
    }

    public static void main(String[]args){
	Silver test = new Silver();
	System.out.println(test.solution());
    }
}
