/**

 author Ken Nguyen
 version 1.0
 */


public class RandomMaze {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 30;

    private static final char WALL = '#';
    private static final char BLANK = ' ';


    /**
     * Create a frame of maze
     *
     * @return 2D array of maze frame
     */
    private static char[][] createFrame() {

        char[][] frame = new char[HEIGHT][WIDTH];

        //create a blank frame
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                frame[i][j] = BLANK;
            }
        }

        //left column
        for (int i = 0; i < HEIGHT; i++) {
            frame[i][0] = WALL;
        }

        //Right column
        for (int j = 0; j < HEIGHT; j++) {
            frame[j][WIDTH - 1] = WALL;
        }

        //Top column
        for (int k = 0; k < WIDTH; k++) {
            frame[0][k] = WALL;
        }
        //Bottom column
        for (int b = 0; b < WIDTH; b++) {
            frame[HEIGHT - 1][b] = WALL;
        }
        return frame;
    }


    /**
     * generate a random number
     *
     * @param min
     * @param max
     * @return: a random number
     */
    private static int randBetween(int min, int max) {

        int random = (int) (Math.random() * ((max - min))) + min;
        return random;
    }


    /**
     * recursion inside the maze
     * parameter: 2d array
     */

    private static void makeMazeRecursive(char[][] level, int startX, int startY, int endX, int endY) {
        // base cases
        if ((endX - startX) <=2 )  {
            return;
        }
        if ((endY - startY) <=2)  {
            return;
        }

        // random new X and new y coordinates
       int newY = randBetween(startY+1, endY-1);
       int newX  = randBetween(startX+1, endX-1);

        //create new column
        for (int i = startY; i <= endY; i++) {
            level[i][newX] = WALL;
        }
        level[randBetween(startY, newY-1)][newX] = BLANK; //random hole from startY to newY with newX(upper)
        level[randBetween(newY-1, endY)][newX] = BLANK; //random hole from newY to endY with newX(lower)
        level[randBetween(startY, endY)][newX] = BLANK; //random hole from startY to endY with newX (anywhere from top to bottom)

        //create new row
        for (int j = startX; j <= endX; j++) {
            level[newY][j] = WALL;
        }
        level[newY][randBetween(startX, newX-1)] = BLANK; // random hole from startX to new X (Left)
        level[newY][randBetween(newX, endX)] = BLANK; // random hole from newX to endX (Right)
        level[newY][randBetween(startX, endX)] = BLANK; // random hole from startX to endX with newY (anywhere from left to right)


        // call each sub-areas using recursion(total 4 areas)
        makeMazeRecursive(level, startX+1, startY+1, newX-1, newY-1);  //upper left part
        makeMazeRecursive(level, newX+1, startY+1 , endX-1  , newY-1); //upper right part
        makeMazeRecursive(level, startX+1, newY+1, newX-1, endY-1); //lower left part
        makeMazeRecursive(level, newX+1, newY+1, endX-1, endY-1); //lower right part


    }



    /**
     * create a random maze
     */
    private static char[][] createRandomMaze(){
        //get frame for random Maze
        char[][] randomMaze =createFrame();
        //make random maze
        makeMazeRecursive(randomMaze,1,1,WIDTH-1, HEIGHT-1);
        return randomMaze;
    }

    private static void displayMaze(char[][] maze){

        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
                System.out.print(maze[y][x]);
                System.out.println();
        }
    }

    /**
     * Entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        displayMaze(createRandomMaze());

    }
}

