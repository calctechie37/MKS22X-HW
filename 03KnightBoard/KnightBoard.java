public class KnightBoard{
    private int[][]board;

    private int[] movesx = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] movesy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public KnightBoard(int size){
	board = new int[size][size];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		board[i][j] = 0;
	    }
	}
    }

    public boolean solve(){
	int i = 0;
	boolean solved = false;
	while (i < board.length and !solved){
	    int j = -1;
	    while (j < board.length && !solved){
		j++;
		solved = solveTour(i, j, 2);
	    }
	}
    }

    public boolean solveTour(int row, int col, int moves){
	if (moves == 2){
	    board[row][col] = 1;
	}	
	if (moves > board.length * board.length){
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
	    for(int j = 0; j < board.length; j++){
		board[i][j] = 0;
	    }
	}
	return false;
    }
    
    public void printSolution(){
	String result = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		if (board[i][j] < 10){
		    result += " " + board[i][j];
		} else{
		    result += "" + board[i][j];
		}
		result += " ";
	    }
	}
    }
}
