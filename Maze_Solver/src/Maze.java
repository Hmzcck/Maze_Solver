import java.util.ArrayList;



public class Maze {
  char mz[][];
  int startRow = 0;
  int endRow = 0;
  int endRow2 = 0;
  Position startPos = new Position(0, 0);
  ArrayList<char[][]> mazes = new ArrayList<>();
  Stack<char[][]> checker = new Stack<>();
  public Maze(int[][] Marr) {
    mz = new char[Marr.length][Marr[0].length];
    endRow = Marr.length - 1;
    endRow2 = Marr[0].length - 1;
    for (int i = 0; i < Marr.length; i++) {
      for (int j = 0; j < Marr[0].length; j++) {
        if (Marr[i][j] == 0) {
          mz[i][j] = 'R';// can reach
        } else {
          mz[i][j] = 'X';// wall
        }
      }
    }
  }
  private boolean equality(char[][] arr1 , char[][] arr2)
  {
    for(int i=0;i<arr1.length;i++)
    {
      for(int j=0;j<arr1[0].length;j++)
      {
        if(arr1[i][j]!=arr2[i][j])
          return false;
      }
    }
    return true;
  }
  public void solveMaze() throws Exception {
    int ct = 1;
    while (true) {
      try {
        solveMaze(mz, startPos, ct);
      } catch (Exception exs) {

      }
      for (int i = 0; i < mazes.size() - 1; i++) {
        if (equality(mazes.get(mazes.size() - 1), mazes.get(i))) {
          System.out.println("Terminated.");
          return;
        }
      }
      if( checker.isEmpty())
        {
          System.out.println("No solution.");
          return;
        }
      System.out.println(ct + ". Solution:");
      printer(mazes.get(ct-1));
      ct++;
    }

  }

  private void solveMaze(char[][] maze, Position current, int counter) throws Exception {

    if (current.getX() == endRow & current.getY() == endRow2) {

      

      addAr(mz);
      checker.push(mz);
      resetter(maze);
      // printer();
      throw new Exception();
    }

    down(maze, current, counter);

    downright(maze, current, counter);

    downleft(maze, current, counter);

    right(maze, current, counter);

    left(maze, current, counter);

    up(maze, current, counter);

    upright(maze, current, counter);

    upleft(maze, current, counter);

    down2(maze, current, counter);

    downright2(maze, current, counter);

    downleft2(maze, current, counter);

    right2(maze, current, counter);

    left2(maze, current, counter);

    up2(maze, current, counter);

    upright2(maze, current, counter);

    upleft2(maze, current, counter);

    // check if no way
    if (current.getX() == 0) {
      if (current.getY() == 0) {
        if (maze[current.getX() + 1][current.getY()] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
            & maze[current.getX() + 1][current.getY() + 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() + 1] != 'H'
            & maze[current.getX() + 1][current.getY() + 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (current.getY() == maze[0].length - 1) {
        if (maze[current.getX() + 1][current.getY()] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
            & maze[current.getX() + 1][current.getY() - 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() - 1] != 'H'
            & maze[current.getX() + 1][current.getY() - 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (maze[current.getX() + 1][current.getY()] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
          & maze[current.getX() + 1][current.getY() + 1] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
          & maze[current.getX() + 1][current.getY() - 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'H'
          & maze[current.getX()][current.getY() + 1] != 'H'
          & maze[current.getX() + 1][current.getY() + 1] != 'H' & maze[current.getX()][current.getY() - 1] != 'H'
          & maze[current.getX() + 1][current.getY() - 1] != 'H') {
        maze[current.getX()][current.getY()] = 'C';
        return;
      } else
        return;
    }

    if (current.getX() == maze.length - 1) {
      if (current.getY() == 0) {
        if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
            & maze[current.getX() - 1][current.getY() + 1] != 'R' & maze[current.getX() - 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() + 1] != 'H'
            & maze[current.getX() - 1][current.getY() + 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (current.getY() == maze[0].length - 1) {
        if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
            & maze[current.getX() - 1][current.getY() - 1] != 'R' & maze[current.getX() - 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() - 1] != 'H'
            & maze[current.getX() - 1][current.getY() - 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
          & maze[current.getX() - 1][current.getY() + 1] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
          & maze[current.getX() - 1][current.getY() - 1] != 'R' & maze[current.getX() - 1][current.getY()] != 'H'
          & maze[current.getX()][current.getY() + 1] != 'H'
          & maze[current.getX() - 1][current.getY() + 1] != 'H' & maze[current.getX()][current.getY() - 1] != 'H'
          & maze[current.getX() - 1][current.getY() - 1] != 'H') {
        maze[current.getX()][current.getY()] = 'C';
        return;
      } else
        return;
    }

    if (current.getY() == 0) {
      if (current.getX() == 0) {
        if (maze[current.getX() + 1][current.getY()] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
            & maze[current.getX() + 1][current.getY() + 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() + 1] != 'H'
            & maze[current.getX() + 1][current.getY() + 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (current.getX() == maze.length - 1) {
        if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
            & maze[current.getX() - 1][current.getY() + 1] != 'R' & maze[current.getX() - 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() + 1] != 'H'
            & maze[current.getX() - 1][current.getY() + 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
          & maze[current.getX() - 1][current.getY() + 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'R'
          & maze[current.getX() + 1][current.getY() + 1] != 'R' & maze[current.getX() - 1][current.getY()] != 'H'
          & maze[current.getX()][current.getY() + 1] != 'H'
          & maze[current.getX() - 1][current.getY() + 1] != 'H' & maze[current.getX() + 1][current.getY()] != 'H'
          & maze[current.getX() + 1][current.getY() + 1] != 'H') {
        maze[current.getX()][current.getY()] = 'C';
        return;
      } else
        return;
    }

    if (current.getY() == maze[0].length - 1) {
      if (current.getX() == 0) {
        if (maze[current.getX() + 1][current.getY()] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
            & maze[current.getX() + 1][current.getY() - 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() - 1] != 'H'
            & maze[current.getX() + 1][current.getY() - 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (current.getX() == maze.length - 1) {
        if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
            & maze[current.getX() - 1][current.getY() - 1] != 'R' & maze[current.getX() - 1][current.getY()] != 'H'
            & maze[current.getX()][current.getY() - 1] != 'H'
            & maze[current.getX() - 1][current.getY() - 1] != 'H') {
          maze[current.getX()][current.getY()] = 'C';
          return;
        }
      } else if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
          & maze[current.getX() - 1][current.getY() - 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'R'
          & maze[current.getX() + 1][current.getY() - 1] != 'R' & maze[current.getX() - 1][current.getY()] != 'H'
          & maze[current.getX()][current.getY() - 1] != 'H'
          & maze[current.getX() - 1][current.getY() - 1] != 'H' & maze[current.getX() + 1][current.getY()] != 'H'
          & maze[current.getX() + 1][current.getY() - 1] != 'H') {
        maze[current.getX()][current.getY()] = 'C';
        return;
      } else
        return;
    }

    if (maze[current.getX() - 1][current.getY()] != 'R' & maze[current.getX()][current.getY() - 1] != 'R'
        & maze[current.getX() - 1][current.getY() - 1] != 'R' & maze[current.getX() + 1][current.getY()] != 'R'
        & maze[current.getX() + 1][current.getY() - 1] != 'R' & maze[current.getX()][current.getY() + 1] != 'R'
        & maze[current.getX() - 1][current.getY() + 1] != 'R' & maze[current.getX() + 1][current.getY() + 1] != 'R'
        & maze[current.getX() - 1][current.getY()] != 'H' & maze[current.getX()][current.getY() - 1] != 'H'
        & maze[current.getX() - 1][current.getY() - 1] != 'H' & maze[current.getX() + 1][current.getY()] != 'H'
        & maze[current.getX() + 1][current.getY() - 1] != 'H' & maze[current.getX()][current.getY() + 1] != 'H'
        & maze[current.getX() - 1][current.getY() + 1] != 'H' & maze[current.getX() + 1][current.getY() + 1] != 'H') {
      maze[current.getX()][current.getY()] = 'C';
      return;
    }

  }

  private void printer(char[][] arr2) {
   
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[0].length; j++) {
        System.out.print(arr2[i][j]);
      }
      System.out.println();
    }
  }

  private void resetter(char[][] mzs) {
    for (int i = 0; i < mz.length; i++) {
      for (int j = 0; j < mz[0].length; j++) {
        if (mzs[i][j] == 'W') {
          mzs[i][j] = 'H';
        }
      }

    }
    for (int i = 0; i < mz.length; i++) {
      for (int j = 0; j < mz[0].length; j++) {
        if (mzs[i][j] == 'C') {
          mzs[i][j] = 'R';
        }
      }

    }
  }

  private void arrCopy(char[][] arr1, char[][] arr2) {
    for (int i = 0; i < mz.length; i++) {
      for (int j = 0; j < mz[0].length; j++) {
        arr2[i][j] = arr1[i][j];
      }

    }
  }
  private void addAr(char[][] mzAr)
  {
    char[][] arr2 = new char[mzAr.length][mzAr[0].length];
    arrCopy(mzAr, arr2);

    for (int i = 0; i < arr2.length; i++) {

      for (int j = 0; j < arr2[0].length; j++) {
        if (arr2[i][j] != 'W' & arr2[i][j] != 'H') {
          arr2[i][j] = '.';
        } else if (arr2[i][j] == 'W' | arr2[i][j] == 'H') {
          arr2[i][j] = '#';
        }
      }
    }
    mazes.add(arr2);
    arr2[endRow][endRow2] = '#';
  }

  private void down(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() - 1 > -1) // alt
    {
      if (maze[current.getX() - 1][current.getY()] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() - 1, current.getY()), counter);
      }
    }
  }

  private void downright(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() - 1 > -1 & current.getY() + 1 < maze[0].length)// sag alt capraz
    {
      if (maze[current.getX() - 1][current.getY() + 1] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// wen
        solveMaze(maze, new Position(current.getX() - 1, current.getY() + 1), counter);
      }
    }
  }

  private void downleft(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() - 1 > -1 & current.getY() - 1 > -1)// sol alt capraz
    {
      if (maze[current.getX() - 1][current.getY() - 1] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() - 1, current.getY() - 1), counter);
      }
    }
  }

  private void right(char[][] maze, Position current, int counter) throws Exception {
    if (current.getY() + 1 < maze[0].length) // sag
    {
      if (maze[current.getX()][current.getY() + 1] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX(), current.getY() + 1), counter);
      }
    }
  }

  private void left(char[][] maze, Position current, int counter) throws Exception {
    if (current.getY() > 0) // sol
    {
      if (maze[current.getX()][current.getY() - 1] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX(), current.getY() - 1), counter);
      }
    }
  }

  private void up(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() + 1 < maze.length)// ust
    {
      if (maze[current.getX() + 1][current.getY()] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// went

        solveMaze(maze, new Position(current.getX() + 1, current.getY()), counter);
      }
    }
  }

  private void upright(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() + 1 < maze.length & current.getY() + 1 < maze[0].length)// sag ust capraz
    {
      if (maze[current.getX() + 1][current.getY() + 1] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() + 1, current.getY() + 1), counter);
      }
    }
  }

  private void upleft(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() + 1 < maze.length & current.getY() - 1 > -1)// sol ust capraz
    {
      if (maze[current.getX() + 1][current.getY() - 1] == 'R') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() + 1, current.getY() - 1), counter);
      }
    }
  }

  private void down2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() - 1 > -1) // alt
    {
      if (maze[current.getX() - 1][current.getY()] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() - 1, current.getY()), counter);
      }
    }
  }

  private void downright2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() - 1 > -1 & current.getY() + 1 < maze[0].length)// sag alt capraz
    {
      if (maze[current.getX() - 1][current.getY() + 1] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// wen
        solveMaze(maze, new Position(current.getX() - 1, current.getY() + 1), counter);
      }
    }
  }

  private void downleft2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() - 1 > -1 & current.getY() - 1 > -1)// sol alt capraz
    {
      if (maze[current.getX() - 1][current.getY() - 1] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() - 1, current.getY() - 1), counter);
      }
    }
  }

  private void right2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getY() + 1 < maze[0].length) // sag
    {
      if (maze[current.getX()][current.getY() + 1] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX(), current.getY() + 1), counter);
      }
    }
  }

  private void left2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getY() > 0) // sol
    {
      if (maze[current.getX()][current.getY() - 1] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX(), current.getY() - 1), counter);
      }
    }
  }

  private void up2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() + 1 < maze.length)// ust
    {
      if (maze[current.getX() + 1][current.getY()] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// went

        solveMaze(maze, new Position(current.getX() + 1, current.getY()), counter);
      }
    }
  }

  private void upright2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() + 1 < maze.length & current.getY() + 1 < maze[0].length)// sag ust capraz
    {
      if (maze[current.getX() + 1][current.getY() + 1] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() + 1, current.getY() + 1), counter);
      }
    }
  }

  private void upleft2(char[][] maze, Position current, int counter) throws Exception {
    if (current.getX() + 1 < maze.length & current.getY() - 1 > -1)// sol ust capraz
    {
      if (maze[current.getX() + 1][current.getY() - 1] == 'H') {
        maze[current.getX()][current.getY()] = 'W';// went
        solveMaze(maze, new Position(current.getX() + 1, current.getY() - 1), counter);
      }
    }
  }

}