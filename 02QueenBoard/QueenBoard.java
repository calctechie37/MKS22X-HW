public class QueenBoard{

    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public boolean solve(){
	return solveHelper(0);
    }

    private boolean solveHelper(int col){
	for(int row = 0; row < board.length; row++){
	    if (addQueen(row, col)){
		if (col == board.length - 1){
		    return true;
		}
		if (solveHelper(col + 1)){
		    return true;
		}else{
		    removeQueen(row, col);
		}
	    }
	}
	return false;
    }
	

    public void printSolution(){
	String result = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board.length; col++){
		if (board[row][col] == 1){
		    result += "Q ";
		} else{
		    result += "_ ";
		}
	    }
	    result += "\n";
	}
	System.out.println(result);
    }
    
    private boolean addQueen(int row, int col){
	// check if a queen can exists here
	if (board[row][col] != 0){
	    return false;
	}
	
	// drop a queen here
	board[row][col] = 1;

	// update the board now that a queen is placed
	int n = 1;
	while (col + n < board[row].length){
	    board[row][col + n]--;
	    if (row >= n){
		board[row - n][col + n]--;
	    }
	    if (row + n < board.length){
		board[row + n][col + n]--;
	    }
	    n++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	// check if a queen exists here
	if (board[row][col] != 1){
	    return false;
	}
	
	// remove the queen here otherwise
	board[row][col] = 0;

	// update the board now the queen was removed
	int n = 1;
	while (col + n < board[row].length){
	    board[row][col + n]++;
	    if (row >= n){
		board[row - n][col + n]++;
	    }
	    if (row + n < board.length){
		board[row + n][col + n]++;
	    }
	    n++;
	}
	return true;
    }

    public static void main(String[]args){
	QueenBoard p = new QueenBoard(4);
	p.solve();
	p.printSolution();
	QueenBoard q = new QueenBoard(5);
	q.solve();
	q.printSolution();
	QueenBoard r = new QueenBoard(6);
	r.solve();
	r.printSolution();
    }
}
