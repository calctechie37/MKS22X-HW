public class Main {
    public static void main(String[]args) {
	KnightBoard knightboard;
	if (args.length >= 2) {
	    knightboard = new KnightBoard(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	} else if (args.length == 1) {
	    knightboard = new KnightBoard(Integer.parseInt(args[0]));
	} else {
	    knightboard = new KnightBoard(5);
	}
	knightboard.solve();
	knightboard.printSolution();
    }
    
}
