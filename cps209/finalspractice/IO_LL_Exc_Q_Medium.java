package finalspractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* This example combines File IO, Linked Lists, and Handling Exceptions
*  Since it combines so many topics, this one is a bit trickier. Less code is given to you,
*  and the solution is more open ended to encourage you to think about the solution.
*
*  THERE ARE TWO VERSIONS OF THIS FILE. THIS IS THE MEDIUM DIFFICULTY THAT HAS SOME CODE
*  PROVIDED. THE HARD FILE CONTAINS MINIMAL CODE TO GET YOU STARTED
* 
*  The file "PeopleOrder.txt" contains a database of people and their positions in a 
*  LinkedList. Each row of text is formatted like this:
*  Name #
*  Where the number represents the 0-indexed position that they should go in the current list,
*  and Name is a String of the person's name. */

/* For example, given the start of the file: 
James 0
Megan 1
Paul 1
Jan 0
*  After reading and processing each row, the Linked List would look like this:
James (James inserted at position 0 (the start))
James -> Megan (Megan inserted at position 1)
James -> Paul -> Megan (Paul inserted at position 1)
Jan -> James -> Paul -> Megan (Jan inserted at position 0)
*/

/* INSTRUCTIONS:
 * Use File IO to read the data from the PeopleOrder.txt file. Use exception handling and a
 * LinkedList to filfill the following criteria:
 *  -Make sure the file is opened properly
 *  -If a name is to be inserted at an invalid position, display a message to the user
 *  -If the row cannot be properly read and broken into the position and name, display a message 
 *   to the user and continue reading the file
 *  -Upon completing the file, display the completed linkedlist
 * 
 * Hint - use an iterator to add elements to their correct position
 */


public class IO_LL_Exc_Q_Medium {

    // This function takes a LinkedList, position, and name as input.
    // Iterate through the LinkedList until the desired position is found,
    // then insert at the position.
    // This function should not handle any errors - all handling done in main.
    static void insertNode(LinkedList<String> list, int position, String name) throws NoSuchElementException{

        ListIterator<String> iter = list.listIterator();
        int count = 0;
        
        
    }

    public static void main(String[] args){
        // Pseudocode - intentionally not indented (and not neccessarily in order)
        // to make you think about how to implement the functionality correctly

        try{
            // Read from text file
            File file = new File("PeopleOrder.txt");
            Scanner in = new Scanner (file);

            LinkedList<String> ll = new LinkedList<String>();

            // While there is content to read, read the data
            while (in.hasNextLine()){
                try{
                    // ____
                }
                // If insertion unsuccessful, display message
                // If row couldn't be read, display message
                catch(NoSuchElementException ex){
                    // ____
                }
                // General exception catches anything not caught above
                catch(Exception ex){
                    // ____
                }
            }

            // Close text file
            // ____
        }
        // If text file couldn't be read, display message
        catch(FileNotFoundException ex){
            // ____
        }
        System.out.println("Expected:\n[Jan, James, Jessica, Paul, Daniel, Megan]");
    } 
}