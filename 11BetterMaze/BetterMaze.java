import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node {
	int[] location;
	Node previous;

	public Node(int[] location, Node previous) {
	    this.location = location;
	    this.previous = previous;
	}

	public Node getPrev() {
	    return previous;
	}

	public int[] getLocation() {
	    return location;
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate; // default to false

    public int[] solutionCoordinates(){
	return solution;
    }

    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){
	// Initialize FrontierQueue
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }


    /**initialize the frontier as a stack and call solve
     */
    public boolean solveDFS(){
	// Initialize FrontierStack
	placesToGo = new FrontierStack<Node>();
	return solve();
    }

    /**Search for the end of the maze using the frontier.
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){
        /** IMPLEMENT THIS **/
	// Initialize start values
	int[] startLoc = {startRow, startCol};
	Node start = new Node(startLoc, null);
	placesToGo.add(start);
	// Current values
	int row = startRow;
	int col = startCol;
	int[] coords = startLoc;
	Node curNode = start;
	while (maze[row][col] != 'E') {
	    if (maze[row][col] != 'S') {
		maze[row][col] = '.';
	    }
	    addNeighbors(coords, curNode);
	    if (placesToGo.hasNext()) {
		curNode = placesToGo.next();
		coords = curNode.getLocation();
		row = coords[0];
		col = coords[1];
	    } else {
		return false;
	    }
	    if (animate) {
		System.out.println(this);
		wait(20);
	    }
	}
	solution = coords;
	return true;
    }

    private boolean addNeighbors(int[] coords, Node cur) {
	if (isValid(coords[0], coords[1] + 1)) {
	    placesToGo.add(new Node(new int[]{coords[0], coords[1] + 1}, cur));
	}
	if (isValid(coords[0] - 1, coords[1])) {
	    placesToGo.add(new Node(new int[]{coords[0] - 1, coords[1]}, cur));
	}
	if (isValid(coords[0], coords[1] - 1)) {
	    placesToGo.add(new Node(new int[]{coords[0], coords[1] - 1}, cur));
	}
	if (isValid(coords[0] + 1, coords[1])) {
	    placesToGo.add(new Node(new int[]{coords[0] + 1, coords[1]}, cur));
	}
	return true;
    }

    private boolean isValid(int row, int col) {
	if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
	    return false;
	} else if (maze[row][col] == '#') {
	    return false;
	} else if (maze[row][col] == '.') {
	    return false;
	}
	return true;
    }

    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){ animate = b; }

    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try {
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S') {
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }

    // ====================================================

    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x, int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if (c == '#') {
		ans += color(38,47)+c;
	    } else {
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	} else {
	    return ans + color(37,40) + "\n";
	}
    }

}
