package finalspractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// In this file, we will be reading data from a text file. The text file contains mathematical
// operations for us to complete. Data is presented in the following format:
// ---
// #
// operation (+/-)
// #
// (repeat)

// Read in the number, operation, and other number and display the result of that operation.
// If an unexpected input occurs, print a message to indicate there was an error and skip over 
// the current data group and continue at the next ---. This means that if we come across a 
// problem with the text file, we should continue reading the text file to obtain valid info.

// Function: getfile(String) returns a scanner for the given filename
// Function: parseFile(String) given filename, read through the file and
// print out the results of the valid operation groups. If given a valid
// --- and the following data is invalid, print an error.

public class IOHandling  {

    static Scanner getfile(String filename) throws FileNotFoundException{
        // Create scanner object from the File
        return new Scanner(new File(filename));
    }

    static void parseFile(String filename) throws IOException {
        try {
            Scanner text = getfile(filename);
            while (text.hasNext()) {
                try {
                    String check = text.next();
                if (check.equals("---")) {
                    int int1 = text.nextInt();
                    text.nextLine();
                    String op = text.nextLine();
                    int int2 = text.nextInt();

                    if (op.equals("+")) {
                        System.out.println("" + int1 + "+" + int2 + "=" + (int1+int2));
                    } else if (op.equals("+")) {
                        System.out.println("" + int1 + "-" + int2 + "=" + (int1-int2));
                    }

                    if (text.hasNext()){
                            text.nextLine();
                    }
                }
                } catch (Exception e) { //nested try catch
                    System.out.println("invalid format");
                }
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        parseFile("BadMath1.txt");
        System.out.println("______");
        parseFile("BadMath2.txt");

    }


}