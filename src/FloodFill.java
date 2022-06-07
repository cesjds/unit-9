import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

/**
 * Written by: Yoav Amit
 *
 * Period: 1
 *
 * ASSIGNMENT:  To write a program that asks the user to input the
 * name of a datafile containing the outline of a figure. Then ask
 * for the row and column where the user would like to begin the
 * floodfill, use recursion to do the floodfill and then print the
 * final figure.  You will need:
 *
 * -  a fill method that asks the user for a file name and reads a
 * ‘shape’ from a data file into a 2D array of chars.
 *
 * -  a print method that asks the user for a starting point.
 * If the point is inside the shape, you should recursively
 * floodfill the shape. If the point is outside the shape the 2
 * ‘background’ should be floodfilled.  If the point is on a line
 * nothing should happen.  Error check the row & column to make
 * sure they are in the 2D array.
 * You should use a monospace font to print.
 * You can Consolas for pc's or Menlo for macs.
 *
 * -  a second print method that prints the floodfilled shape
 * and asks the user if (s)he would like to fill another shape.
 *
 * -  a recursive floodFill method that does the floodfill.
 *
 *
 * The data file will be in the form:
 *
 * 		#rows #cols
 * 		row col (for each point in shape)
 * 		row col
 * 		etc…
 *
 * your program should continue reading data files and floodfilling
 * until the user wants to quit.
 *
 **/

public class FloodFill {
    public static void main(String[] args) {
        changeJOP();
        int again = 0;
        char[][] picture;

        do {
            picture = readIn();
            String start = printEmptyShape(picture);
            String[] pieces = start.split("\\s+");
            int startRow = Integer.parseInt(pieces[0]);
            int startCol = Integer.parseInt(pieces[1]);
            floodFill(picture, startRow, startCol);
            again = printFilledShape(picture);
        } while (again == 0);
    }

    /**
    asks the user for a file name and reads a ‘shape’ from a data file into a 2D array of chars.
     **/
    public static char[][] readIn() {
        try {
            // Prompting the user for the text file name
//            String fileName = JOptionPane.showInputDialog("Enter the file name:");

            // Give direct data for testing
            String fileName = "ff1";

            // Opening the file and confirming that the file is being read
            Scanner inFile = new Scanner(new File("data/" + fileName.toLowerCase() + ".txt"));
            String message = "Extracting data from: " + fileName.toLowerCase() + ".txt";

            // Finding the amount of rows and columns
            int rows = inFile.nextInt();
            int columns = inFile.nextInt();

            // Declaring the array with proper rows and columns
            char[][] grid = new char[rows][columns];

            // Filling the array with blank spaces
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    grid[r][c] = ' ';
                }
            }

            // Declaring variables to use as x and y coordinates
            // Filling the array with '*' according to text file
            while (inFile.hasNext()) {
                int x = inFile.nextInt();
                int y = inFile.nextInt();
                grid[x][y] = '*';
            }

            // Closing the file
            inFile.close();

            // Returning the array
            return grid;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     asks the user for a starting point.
     If the point is inside the shape, you should recursively
     floodfill the shape. If the point is outside the shape the 2
     ‘background’ should be floodfilled.  If the point is on a line
     nothing should happen.  Error check the row & column to make
     sure they are in the 2D array.
     **/
    public static String printEmptyShape(char[][] picture) {
        String strGrid = "  ";

        for (int c = 0; c < picture[0].length; c++) {
            strGrid += (c % 10 + "  ");
        }

        strGrid += "\n";

        for (int r = 0; r < picture.length; r++) {
            strGrid += (r % 10);

            strGrid += " ";

            for (int c = 0; c < picture[0].length; c++)
                strGrid += (picture[r][c] + "  ");

            strGrid += "\n";
        }

        // Tests the printArray method using SOP since JOP isn't using a monospace font
        System.out.println(strGrid);

        // Prompts user for starting row and column
        String coordinates = "Enter starting row and column:";
        return JOptionPane.showInputDialog(null, coordinates);
    }


    /**
     * a second print method that prints the floodfilled shape
     * and asks the user if (s)he would like to fill another shape.
     */
    public static int printFilledShape(char[][] picture) {
        String strGrid = "  ";

        for (int c = 0; c < picture[0].length; c++) {
            strGrid += (c % 10 + "  ");
        }

        strGrid += "\n";

        for (int r = 0; r < picture.length; r++) {
            strGrid += (r % 10);

            strGrid += " ";

            for (int c = 0; c < picture[0].length; c++)
                strGrid += (picture[r][c] + "  ");

            strGrid += "\n";
        }

        // Tests the printArray method using SOP since JOP isn't using a monospace font
        System.out.println(strGrid);

        // Asks the user if he would like to run the program again
        String again = JOptionPane.showInputDialog(null, "Do you want to run this program again?");
        if (again.equalsIgnoreCase("yes"))
            return 0;
        else
            return 1;
    }


    /**
     a recursive floodFill method that does the floodfill.
     **/
    public static void floodFill (char[][] picture, int startRow, int startCol) {
        if (picture[startRow][startCol] == '*' || startRow < 0 || startCol < 0 || startRow >= picture.length || startCol >= picture[0].length)
            return;
        else {
            picture[startRow][startCol] += '*';
            floodFill(picture, startRow - 1, startCol);
            floodFill(picture, startRow, startCol - 1);
            floodFill(picture, startRow + 1, startCol);
            floodFill(picture, startRow, startCol + 1);
        }
    }

    /**
    changes the font to a mono font in order to make JOP print a square grid that works
    **/
    public static void changeJOP() {
        // The font of the message text
        UIManager.put("Label.font", new FontUIResource(new Font("Menlo", Font.PLAIN, 24)));
        // The color of the message text
        UIManager.put("OptionPane.messageForeground",new Color(0, 0, 0));

        // color for text field (where you are inputting data)
        UIManager.put("TextField.background", Color.white);
        // font for message in text field
        UIManager.put("TextField.font", new FontUIResource(new Font("Menlo", Font.PLAIN, 24)));
        // color for message in text field
        UIManager.put("TextField.foreground", Color.black);

        // The color of the panel
        UIManager.put("Panel.background",new Color(68, 68, 68));
        // The color around the outside of the panel
        UIManager.put("OptionPane.background",new Color(68, 68, 68));

        // Buttons at bottom
        UIManager.put("Button.background",new Color(255, 255, 255));
        UIManager.put("Button.foreground", new Color(0, 0, 0));
        UIManager.put("Button.font", new FontUIResource	(new Font("Menlo", Font.PLAIN, 14)));
    }
}
