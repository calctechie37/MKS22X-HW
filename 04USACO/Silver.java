import java.util.*;
import java.io.*;

public class Silver{

    public char[][]pasture;
    public int solution;
    public int time;
    public int[] start;
    public int[] end;
    
    public Silver(){
	try{
	    File infofile = new File("ctravel.in");
	    Scanner in = new Scanner(infofile);

	    ArrayList<String> lines = new ArrayList<String>();

	    while (in.hasNextLine()){
		String line = in.nextLine();
		lines.add(line.toUpperCase());
	    }
	    
	    String[] data = lines.get(0).split(" ");
	    int N = Integer.parseInt(data[0]);
	    int M = Integer.parseInt(data[1]);
	    time = Integer.parseInt(data[2]);
	    pasture = new char[N][M];

	    for(int i = 0; i < N; ++i){
		String line = lines.get(i + 1);
		
		for(int j = 0; j < M; ++j){
		    pasture[i][j] = line.charAt(j);
		}
	    }

	    String[] L = lines.get(N + 1).split(" ");
	    start = new int[]{Integer.parseInt(L[0]) - 1, Integer.parseInt(L[1]) - 1};
	    end = new int[]{Integer.parseInt(L[2]) - 1, Integer.parseInt(L[3]) - 1};
	    solution = 0;
	}catch (FileNotFoundException e){
	    System.out.println("Unable to find file!");
	    System.exit(0);
	}

	
    }

    public int solve(){
	solve(start, end, time);
	return solution;
    }

    public void solve(int[] s, int[] e, int t){
	try{
	    if (t == 0 && s[0] == e[0] && s[1] == e[1]){
		solution++;
		return;
	    }
	    if (pasture[s[0]][s[1]] == '*' || t == 0){
		return;
	    }
	    
	    int[] up = new int[]{s[0], s[1] - 1};
	    int[] down = new int[]{s[0], s[1] + 1};
	    int[] left = new int[]{s[0] - 1, s[1]};
	    int[] right = new int[]{s[0] + 1, s[1]};
	    solve(up, e, t - 1);
	    solve(down, e, t - 1);
	    solve(left, e, t - 1);
	    solve(right, e, t - 1);
	}catch (Exception ex){
	}
    }
	
    public static void main(String[]args){
	Silver test = new Silver();
	System.out.println(test.solve());
    }
}
