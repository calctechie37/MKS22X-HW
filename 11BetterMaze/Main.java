public class Main{
    public static void main(String[] args) {
	BetterMaze bm;
	if (args.length > 0) {
	    bm = new BetterMaze(args[0]);
	} else {
	    bm = new BetterMaze("data1.dat");
	}
	bm.setAnimate(true);
	//bm.solveBFS();
	bm.solveDFS();
	System.out.println(bm);
    }
}
