public class KnightBoard{
    private int[][]board;

    private int[] movesx = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] movesy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public KnightBoard(int rows, int cols){
	board = new int[rows][cols];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(){
	int i = 0;
	boolean solved = false;
	while (i < board.length && !solved){
	    int j = -1;
	    while (j < board[0].length && !solved){
		j++;
		solved = solveTour(i, j, 1);
	    }
	}
	return solved;
    }

    public boolean isSafe(int row, int col){
	return ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length) && (board[row][col] == -1));
    }
    
    public boolean solveTour(int row, int col, int moves){
	if (moves == 1){
	    board[row][col] = 1;
	}	
	if (moves > board.length * board[0].length){
	    return true;
	}
	for(int i = 0; i < movesx.length; i++){
	    int nextrow = row + movesx[i];
	    int nextcol = col + movesy[i];
	    if (isSafe(nextrow, nextcol)){
		board[nextrow][nextcol] = moves;
		moves++;
		if (solveTour(nextrow, nextcol, moves)){
		    return true;
		} else{
		    board[nextrow][nextcol] = 0;
		    moves--;
		}
	    }
	}
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		board[i][j] = 0;
	    }
	}
	return false;
    }
    
    public void printSolution(){
	String result = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		if (board[i][j] < 10){
		    result += " " + board[i][j];
		} else{
		    result += "" + board[i][j];
		}
		result += " ";
	    }
	    result += "\n";
	}
	System.out.println(result);
    }
}
