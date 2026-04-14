package finalspractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

//// File IO

// Quick and easy way to read in data to a program. Not limited by user's typing speed.
// Read through a text file like reading through an input. Use the scanner on a File object.

public class IOexample {

    static void pout(Object data){
        System.out.println(data);
    }
    
    
    public static void main(String[] args){

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int sum = 0;
        
        try{
            System.out.println("Opening file");

            // Create file object using name of file
            File inFile = new File("X.txt");
            Scanner text = new Scanner(inFile);
            
            String line1 = text.nextLine();
            pout(line1);

            for (int i = 0; i<3; i++){
                int num = text.nextInt();
                pout( num );
            }
            // nextInt doesn't get rid of the \n after it! Seems to read \n before it without issue 
            text.nextLine();

            // Second half, "Name,0" format
            pout(text.nextLine());
            
            for (int i = 0; i<4; i++){
                // Read in String from file, create scanner to parse the string
                String row = text.nextLine();
                Scanner parse = new Scanner(row);

                // Set the delimeter so next() knows when to stop
                // NOTE!! Using delimiter on string instead of text file.
                parse.useDelimiter(",");

                String newName = parse.next();
                int newNum = parse.nextInt();
                pout("Name " + newName + " Num "+newNum);
                sum += newNum;

                // Put data into arraylists
                names.add(newName);
                nums.add(newNum);
                parse.close();
            }
            System.out.println("----\n" + names);
            System.out.println(nums);
            
            text.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("In File not found!");
        }

        // Write out to a new file!

        try{
            PrintWriter out = new PrintWriter("Y.txt");

            // Header text
            out.println("List of names and numbers in X.txt - Sum = " + sum);

            if (names.size() == 0){
                out.println("---");
            }
            else {
                // Print all data to the text file
                // using nums.size in case a name was read but the num wasn't read successfully
                for (int i = 0; i<nums.size(); i++){
                    out.println(names.get(i) + "\t" + nums.get(i));
                }
            }

            out.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Out File not found!");
        }
        catch (Exception ex){
            System.out.println("Something terrible happened!");
        }

    }
}


// nextInt, nextDouble, next do not consume white space following number or word