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
        int again;
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
            String fileName = JOptionPane.showInputDialog("Enter the file name:");

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

        // Prompts user for starting row and column
        strGrid += "\n\nEnter starting row and column:";
        return JOptionPane.showInputDialog(null, strGrid);
    }

    /**
     * a second print method that prints the floodfilled shape
     * and asks the user if (s)he would like to fill another shape.
     */
    public static int printFilledShape(char[][] picture) {
        String filledStrGrid = "  ";

        for (int c = 0; c < picture[0].length; c++) {
            filledStrGrid += (c % 10 + "  ");
        }

        filledStrGrid += "\n";

        for (int r = 0; r < picture.length; r++) {
            filledStrGrid += (r % 10);

            filledStrGrid += " ";

            for (int c = 0; c < picture[0].length; c++)
                filledStrGrid += (picture[r][c] + "  ");

            filledStrGrid += "\n";
        }

        filledStrGrid += "\n\nWould you like to fill another shape?";

        // Creates buttons to ask if user would like to run program again
        String[] buttons = {"Yes",
                "No"};

        int choice = JOptionPane.showOptionDialog
                (null, filledStrGrid, "Choice",
                        0, 3, null, buttons, null);

        switch (choice) {
            case 0: return 0;
            case 1: return 1;
            default: return 1;
        }
    }

    /**
     a recursive floodFill method that does the floodfill.
     **/
    public static void floodFill (char[][] picture, int startRow, int startCol) {
        if (startRow < 0 || startCol < 0 || startRow > picture.length - 1 || startCol > picture[0].length - 1 || picture[startRow][startCol] == '*') {
            return;
        }
        else {
            picture[startRow][startCol] = '*';
            floodFill(picture, startRow + 1, startCol);
            floodFill(picture, startRow, startCol + 1);
            floodFill(picture, startRow - 1, startCol);
            floodFill(picture, startRow, startCol - 1);
        }
    }

    /**
    changes the font to a mono font in order to make JOP print a square grid that works
    **/
    public static void changeJOP() {
        // The font of the message text
        UIManager.put("Label.font", new FontUIResource(new Font("Consolas", Font.PLAIN, 24)));
        // The color of the message text
        UIManager.put("OptionPane.messageForeground",new Color(0, 0, 0));

        UIManager.put("OptionPane.ShowInputDialog", new FontUIResource(new Font("Consolas", Font.PLAIN, 24)));

        // color for text field (where you are inputting data)
        UIManager.put("TextField.background", Color.white);
        // font for message in text field
        UIManager.put("TextField.font", new FontUIResource(new Font("Consolas", Font.PLAIN, 24)));
        // color for message in text field
        UIManager.put("TextField.foreground", Color.black);

        // The color of the panel
        UIManager.put("Panel.background",new Color(68, 68, 68));
        // The color around the outside of the panel
        UIManager.put("OptionPane.background",new Color(68, 68, 68));

        // Buttons at bottom
        UIManager.put("Button.background",new Color(255, 255, 255));
        UIManager.put("Button.foreground", new Color(0, 0, 0));
        UIManager.put("Button.font", new FontUIResource	(new Font("Consolas", Font.PLAIN, 14)));
    }
}
