package finalspractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        int a = 0;
        int b = 0;
        int c = 0;
        try {
            Scanner text = getfile(filename);
            String line1=text.nextLine();
            if (line1.equals("---")) {
                a = text.nextInt();
                text.nextLine();
            } //error print if not then skip to next ---
            String op = text.nextLine();
            if (op.equals("+")) {
                b = text.nextInt();
                text.nextLine();
                c = a+b;
            } else if (op.equals("-")) {
                b = text.nextInt();
                text.nextLine();
                c = a-b;
            } else {
                throw new IOException("incorect formatting");
            }
            System.out.println(a+op+b+"="+c);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) throws IOException{
        parseFile("BadMath1.txt");
        System.out.println("______");
        parseFile("BadMath2.txt");

    }


}