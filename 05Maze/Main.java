public class Main{

    public static void main(String[]args){
        Maze f;
	if (args.length >= 1) {
	    f = new Maze(args[0], true);
	} else {
	    f = new Maze("data1.dat", true);//true animates the maze.
        }

	f.clearTerminal();
	System.out.println(f);
	
        f.clearTerminal();
        f.solve();

        f.clearTerminal();
        System.out.println(f);
    }
}
