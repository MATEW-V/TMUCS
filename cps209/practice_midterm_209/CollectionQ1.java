import java.util.ArrayList;

public class CollectionQ1 
{
    /*
     * FULL NAME:  Matthew Vuong
     * STUDENT ID: 501348434
     */

    public static ArrayList<String> collectShortWords(ArrayList<String> list, int k)
    {
        /* 
         * This method accepts an ArrayList of Strings as input. Create a new
         * ArrayList of Strings containing those strings from the input list that
         * have fewer than k characters. Your modified method should return the new
         * ArrayList. Do not modify the input list.
         * 
         * To run the unit tests for this problem, use the following commands in the terminal:
         * 
         * Compile)     javac -cp junit-1.11.0-M2.jar CollectionQ1.java CollectionQ1Test.java
         * Run tests)   java -jar junit-1.11.0-M2.jar execute -cp . -c CollectionQ1Test 
         * 
         * This method is worth 10 marks
         */
        ArrayList<String> res = new ArrayList<String>();
        for (String s: list) {
            if (s.length()<k) {
                res.add(s);
            }
        }
        return res;
    }
}
