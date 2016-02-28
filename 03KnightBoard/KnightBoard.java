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

    public KnightBoard(int size){
	this(size, size);
	
    }

    public boolean solve(){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[0].length; j++){
		if (solveTour(i, j, 1)){
		    return true;
		}
	    }
	}
	return false;
    }

    public boolean isSafe(int row, int col){
	return ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length) && (board[row][col] == 0));
    }
    
    public boolean solveTour(int row, int col, int moves){
	if (!isSafe(row, col)){
	    return false;
	}
	board[row][col] = moves;
	
	if (moves == board.length * board[0].length){
	    return true;
	}
	for(int i = 0; i < 8; i++){
	    if (solveTour(row + movesx[i], col + movesy[i], moves + 1)){
		return true;
	    }
	}
	board[row][col] = 0;
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
