import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.String.valueOf;

/********************************************************************
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
 *******************************************************************/

public class FloodFill {
    public static void main(String[] args) {
//        char grid[][] = fillArray();
//        printArray(grid);
        printArray(fillArray());
    }

    /**
    asks the user for a file name and reads a ‘shape’ from a data file into a 2D array of chars.
     **/
    public static char[][] fillArray() {
        try {
            // Prompting the user for the text file name
            String fileName = JOptionPane.showInputDialog("Enter a text file:");

            // Opening the file and confirming that the file is being read
            Scanner inFile = new Scanner(new File("data/" + fileName.toLowerCase() + ".txt"));
            String message = "Extracting data from: " + fileName.toLowerCase() + ".txt";
            JOptionPane.showMessageDialog(null, message);

            // Finding the amount of rows and columns
            int rows = inFile.nextInt();
            int columns = inFile.nextInt();

            // Declaring the array with proper rows and columns
            char grid[][] = new char[rows][columns];

            // Filling the array with blank spaces
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    grid[r][c] = ' ';
                }
            }

            // Declaring variables to use as x and y coordinates
            int x = inFile.nextInt();
            int y = inFile.nextInt();

            // Filling the array with '*' according to text file
            while (inFile.hasNext()) {
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < columns; c++) {
                        if(r == x && c == y) {
                            grid[r][c] = '*';
                            x = inFile.nextInt();
                            y = inFile.nextInt();
                        }
                    }
                }
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
    public static void printArray (char[][] grid) {
        for (int r = 0; r < 15; r++) {
            System.out.print("\n");
            for (int c = 0; c < 25; c++) {
                System.out.print(grid[r][c] + " ");
            }
        }
    }


    /**
     a second print method that prints the floodfilled shape
     and asks the user if (s)he would like to fill another shape.
     **/
    public static void printFloodFill () {

    }


    /**
     a recursive floodFill method that does the floodfill.
     **/
    public static void floodFill () {

    }
}
