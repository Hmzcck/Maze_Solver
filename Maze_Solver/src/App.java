import java.io.File;


public class App {
	public static void main(String[] args) throws Exception {
		File file = new File("maze.txt");
		FileReader f = new FileReader();
		int maze[][] = f.read(file);

		Maze mSolve = new Maze(maze);
		mSolve.solveMaze();

	}
}