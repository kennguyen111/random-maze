/**

 author Ken Nguyen
 version 1.0
 */
import java.util.Random;

public class RandomMaze{
    //standard console size in characters.
    private static final int HEIGHT = 25;
    private static final int WIDTH = 80;

    private static final char ICON_WALL = '#';
    private static final char ICON_BLANK = ' ';



    /**
     * Create a maze frame
     * @return 2D array of maze frame
     */
    private static char[][] createFrame() {

        char [][] frame= new char[HEIGHT][WIDTH];

        //create a blank frame
        for(int i=0; i< HEIGHT; i++){
            for (int j=0; j< WIDTH; j++){
                frame[i][j]= ICON_BLANK;
            }
        }


        //left column
        for (int i=0; i <  HEIGHT; i++){
            frame[i][0]= ICON_WALL;
        }

        //Right column
        for (int j=0; j < HEIGHT; j++){
            frame[j][WIDTH-1]= ICON_WALL;
        }

        //Top column
        for (int k =0 ; k <WIDTH; k++){
            frame[0][k]=ICON_WALL;
        }
        //Bottom column
        for (int b=0; b<WIDTH; b++){
            frame[HEIGHT-1][b]=ICON_WALL;
        }


        return frame;
    }

    /**
     * recursion inside the maze

     */


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
        displayMaze(createFrame());
        //displayMaze(createBlankLevel());
    }
}

