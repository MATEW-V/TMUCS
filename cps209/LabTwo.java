import java.util.Arrays;

public class LabTwo 
{
    /*
        Fill in the methods below according to the descriptions given
        in the lab document. See the PDF in this archive.

        You should test your code by calling your methods in the main
        method provided. One sample call is given, but you should write 
        your own test cases in main() and try them out as you go.

        Once you're satisfied that your methods are producing the correct
        results, you can scroll down to the very bottom of this file
        for instructions on how to run the unit tests. 

        Note that your official lab grade will be based on the unit tests
        and not what you wrote in main(), but it's still a good idea 
        to practice writing your own main() method. You won't always be
        given unit tests.
    */

    public static void main (String[] args)
    {
        // Add your own tests here!

        int[] a1 = {42, 99, 17, 33};
        int[] b1 = everyOther(a1);

        System.out.println();
        System.out.println(Arrays.toString(b1));
    }


    public static int[] everyOther(int[] a) 
    {
        int[] res = { 0 };

        return res;
    }
    

    public static int[][] createZigZag(int rows, int cols, int start) 
    {
        int[][] res = { { 0 } };

        return res;
    }
    

    public static void reverseAscendingSubarrays(int[] items) 
    {
        

    }
    

    public static String pancakeScramble(String text) 
    {
        
        return "-";
    }


    /* RUNNING THE UNIT TESTS)
     *
     * Evaluate your code by using the following commands in the terminal.
     * Any time you make changes to your code, you will have to run 
     * both commands again. The first one compiles your code and the 
     * tester into two Java class files. The second command runs the
     * unit tests and displays the results.
     *
     * Compile)
     *  javac -cp junit-1.11.0-M2.jar LabTwo.java LabTwoTest.java
     *
     * Run tests)
     *  java -jar junit-1.11.0-M2.jar execute -cp . -c LabTwoTest
     *
     * When all test report a pass, you're good to go.
     *  
     */
}

